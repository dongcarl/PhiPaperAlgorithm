package edu.choate;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import edu.choate.learn.rVectorPossibilities;
import edu.choate.learn.rVectorProximityHeuristicComparator;
import edu.choate.utils.Deltas;
import edu.choate.utils.IntArrays;
import edu.choate.utils.Sets2;

import java.util.*;

/**
* Created by Yicheng on 5/22/2014.
*/
public class DeltaSystemConstructor
{
    private final int n;
    private final int k;
    private final int TARGET;
    private final double percentExclude;
    private static List<Set<Integer>> E;
    private final Set<Integer> V;
    private static List<Set<Integer>> F;
    private static int[] idealRVector; //need to find ideal R vector
    private static ArrayList<int[]> allPossibleRVectors;

    public ArrayList<int[]> getAllPossibleRVectors()
    {
        if (allPossibleRVectors == null)
        {
            allPossibleRVectors = rVectorPossibilities.allPossibleRVectors(n, TARGET);
        }
        return allPossibleRVectors;
    }

    public DeltaSystemConstructor(int incomingN, int incomingK, int incomingTARGET, double incomingPercentExclude, Set<Integer> incomingSupport)
    {
        n = incomingN;
        k = incomingK;
        TARGET = incomingTARGET;
        percentExclude = incomingPercentExclude;
        E = new ArrayList<Set<Integer>>();
        V = incomingSupport;
        F = new ArrayList<Set<Integer>>(Sets2.getSubsets(V, n));
        System.out.println(V);


        System.out.println("DeltaSystemConstructor called with primitive fields:");
        System.out.println('\t' + "n = " + n);
        System.out.println('\t' + "k = " + k);
        System.out.println('\t' + "TARGET = " + TARGET);
        System.out.println('\t' + "percentExclude = " + percentExclude);

        System.out.println("main function called with Set<Set<Integer>> E =");
        System.out.println("\t" + E);
        System.out.println("main function called with Set<Integer> V =");
        System.out.println("\t" + V);
        System.out.println("main function called with Set<Set<Integer>> F =");
        System.out.println("\t" + F);
        System.out.println("main function called with idealRVector idealRVector =");
        System.out.print("\t[");
        // printing out ideal r vector (create class and make a toString)
        for (int i = 0; i < idealRVector.length; i++)
        {
            if (i < idealRVector.length - 1)
                System.out.print(idealRVector[i] + ", ");
            else
                System.out.print(idealRVector[i] + "]" + '\n');
        }


        //Step 2 shuffle the sets randomly
        System.out.println("Step 2");
        step2(true, E, F, idealRVector); // true = randomly
        System.out.println(E.size());

        //Step 3
        System.out.println("Step 3");
        while (E.size() < TARGET)
        {
            ArrayList<Integer> allSizes = new ArrayList<Integer>();

            for (int[] currentRVector : allPossibleRVectors)
            {
                List<Set<Integer>> eDup = new ArrayList<Set<Integer>>(E);
                List<Set<Integer>> fDup = new ArrayList<Set<Integer>>(F);

                step3Body(eDup, fDup, currentRVector, percentExclude); // removes elements from E to F and

                allSizes.add(eDup.size());
            }

            idealRVector = allPossibleRVectors.get(allSizes.indexOf(Collections.max(allSizes)));

        }

        System.out.println("ended with n");
        System.out.println(n);

        System.out.println("ended with k");
        System.out.println(k);

        System.out.println("ended with TARGET");
        System.out.println(TARGET);

        System.out.println("ended with E");
        System.out.println(E);

        System.out.println("ended with V");
        System.out.println(V);

        System.out.println("ended with F");
        System.out.println(F);
    }

    public void step2(boolean isRandomShuffle, List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int[] incomingRVector)
    {
        if (isRandomShuffle)
        {
            long seed = System.nanoTime();
            Collections.shuffle(incomingF, new Random(seed));
        } else
        {
            Collections.sort(incomingF, new rVectorProximityHeuristicComparator(incomingRVector, F, n));
        }

        Set<Set<Integer>> fDup = new HashSet<Set<Integer>>(incomingF);

        for (Set<Integer> f : fDup)
        {

            Set<Integer> actualF = incomingF.get(incomingF.indexOf(f));
            Set<Set<Integer>> union = new HashSet<Set<Integer>>(incomingE);
            union.add(actualF);

            if (Deltas.isDeltaKFree(union, k))
            {
                incomingE.add(actualF);
                incomingF.remove(actualF);
            }
        }
    }

    public void step3Body(List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int[] incomingIdealRVector, double incomingPercentExclude)
    {
        Set<Set<Integer>> eDup = new HashSet<Set<Integer>>(incomingE);
        Preconditions.checkState(eDup.size() == incomingE.size(), "Duplicating E didn't work properly");

        Set<Set<Integer>> fDup = new HashSet<Set<Integer>>(incomingF);
        Preconditions.checkState(fDup.size() == incomingF.size(), "Duplicating F didn't work properly");


        System.out.println("Starting step 3 with:");
        System.out.println("\tE of size: " + incomingE.size());
        System.out.println("\t\t" + incomingE);
        System.out.println("\tF of size: " + incomingF.size());
        System.out.println("\t\t" + incomingF);
        System.out.println("\tIdeal R-Vector of size: " + incomingIdealRVector.length);
        System.out.println("\t\t" + Arrays.toString(incomingIdealRVector));
        System.out.println("Removing the bottom " + incomingPercentExclude*100 + "% of elements in E and adding them to F");
        System.out.println("--------------------------DON'T MIND ME I'M JUST HERE TO DIVIDE THINGS UP--------------------------");

        ArrayList<Set<Integer>> selectedElements = selectedElements(incomingPercentExclude, incomingE, incomingIdealRVector);
        Preconditions.checkState(incomingE.containsAll(selectedElements), "Some of the selected arguments are not in E");

        int numAdded = incomingF.size();
        incomingF.addAll(selectedElements);
        numAdded = incomingF.size() - numAdded;

        int numRemoved = incomingE.size();
        incomingE.removeAll(selectedElements);
        numRemoved = numRemoved - incomingE.size();

        Preconditions.checkState(numAdded == numRemoved, "The number of elements added to F is not equal to the number of elements removed from E");

//        System.out.println("In the middle of step 3 with:");
//        System.out.println("\tE of size: " + incomingE.size());
//        System.out.println("\t\t" + incomingE);
//        System.out.println("\t\t" + "with " + Sets.difference(eDup, new HashSet<Set<Integer>>(incomingE)) + " removed");
//        System.out.println("\t\t" + "with " + Sets.difference(new HashSet<Set<Integer>>(incomingE), eDup) + " added");
//        System.out.println("\tF of size: " + incomingF.size());
//        System.out.println("\t\t" + incomingF);
//        System.out.println("\t\t" + "with " + Sets.difference(fDup, new HashSet<Set<Integer>>(incomingF)) + " removed");
//        System.out.println("\t\t" + "with " + Sets.difference(new HashSet<Set<Integer>>(incomingF), fDup) + " added");
//        System.out.println("\tIdeal R-Vector of size: " + incomingIdealRVector.length);
//        System.out.println("\t\t" + Arrays.toString(incomingIdealRVector));
//        System.out.println("Removing the bottom " + incomingPercentExclude*100 + "% of elements in E and adding them to F");
//        System.out.println("--------------------------DON'T MIND ME I'M JUST HERE TO DIVIDE THINGS UP--------------------------");
//
//        eDup = new HashSet<Set<Integer>>(incomingE);
//        fDup = new HashSet<Set<Integer>>(incomingF);

        step2(false, incomingE, incomingF, incomingIdealRVector);





        System.out.println("Ending step 3 with:");
        System.out.println("\tE of size: " + incomingE.size());
        System.out.println("\t\t" + incomingE);
        System.out.println("\t\t" + "with " + Sets.difference(eDup, new HashSet<Set<Integer>>(incomingE)) + " removed");
        System.out.println("\t\t" + "with " + Sets.difference(new HashSet<Set<Integer>>(incomingE), eDup) + " added");
        System.out.println("\tF of size: " + incomingF.size());
        System.out.println("\t\t" + incomingF);
        System.out.println("\t\t" + "with " + Sets.difference(fDup, new HashSet<Set<Integer>>(incomingF)) + " removed");
        System.out.println("\t\t" + "with " + Sets.difference(new HashSet<Set<Integer>>(incomingF), fDup) + " added");
        System.out.println("\tIdeal R-Vector of size: " + incomingIdealRVector.length);
        System.out.println("\t\t" + Arrays.toString(incomingIdealRVector));
        System.out.println("Removing the bottom " + incomingPercentExclude*100 + "% of elements in E and adding them to F");
        System.out.println("--------------------------DON'T MIND ME I'M JUST HERE TO DIVIDE THINGS UP--------------------------");
    }

    public ArrayList<Set<Integer>> selectedElements(double incomingExclusionPercentage, Collection<Set<Integer>> incomingE, int[] incomingIdealRVector)
    {
        ArrayList<Set<Integer>> eClone = new ArrayList<Set<Integer>>(incomingE);
        rVectorProximityHeuristicComparator comparator = new rVectorProximityHeuristicComparator(incomingIdealRVector, eClone, n);
        Collections.sort(eClone, comparator);

        BiMap<Set<Integer>, Double> map = HashBiMap.create();

        double sum = 0;
        int[] firstRVec = rVectorProximityHeuristicComparator.rVectorOf(eClone.get(0), eClone);
        double firstRVecProximity = IntArrays.euclideanDistance(firstRVec, incomingIdealRVector);
        for (int i = 0; i < eClone.size(); i++)
        {
            Set<Integer> is = eClone.get(i);
            int[] rVec = rVectorProximityHeuristicComparator.rVectorOf(is, eClone);
            double rVecProximity = IntArrays.euclideanDistance(rVec, incomingIdealRVector);
            double ratio = rVecProximity/firstRVecProximity;
            sum += ratio;
            map.put(is, ratio);
        }

        ArrayList<Double> allProbabilities = new ArrayList<Double>();
        for (Double d : map.values())
        {
            allProbabilities.add(d/sum);
        }

        for (Double d : map.values())
        {
            double randomVal = Math.random();
            if (randomVal < d)
            {
                map.remove(map.inverse().get(d));
            }
        }

        return eClone;
    }

    public static int[] toIntArray(Set<Integer> set)
    {
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer val : set) a[i++] = val;
        return a;
    }
}
