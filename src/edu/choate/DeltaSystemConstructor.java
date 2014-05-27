package edu.choate;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import edu.choate.learn.rVectorPossibilities;
import edu.choate.learn.rVectorProximityHeuristicComparator;
import edu.choate.utils.Deltas;
import edu.choate.utils.IntArrays;
import edu.choate.utils.Sets2;
import edu.choate.utils.rVectors;

import java.util.*;

/**
* Created by Yicheng on 5/22/2014.
*/
public class DeltaSystemConstructor
{
    //need to be provided
    private final int n;
    private final int k;
    private final int TARGET;
    private final Collection<Integer> support;

    //can be generated
    private static List<Set<Integer>> E;
    private static List<Set<Integer>> F;
    private static int[] idealRVector = new int[]{9, 9, 9}; //need to find ideal R vector
    private static ArrayList<int[]> allPossibleRVectors;

    public DeltaSystemConstructor(int incomingN, int incomingK, int incomingTARGET, Collection<Integer> incomingSupport)
    {
        super();

        //set crucial variables
        n = incomingN;
        k = incomingK;
        TARGET = incomingTARGET;
        support = incomingSupport;
    }

    //lazy instantiation
    public List<Set<Integer>> getE()
    {
        if (E == null)
        {
            E = new ArrayList<Set<Integer>>();
        }
        return E;
    }

    public List<Set<Integer>> getF()
    {
        if (F == null)
        {
            F = new ArrayList<Set<Integer>>(Sets2.getSubsets(support, n));
        }
        return F;
    }

    public static ArrayList<int[]> getAllPossibleRVectors(int incomingN, int incomingTARGET)
    {
        if (allPossibleRVectors == null)
        {
            allPossibleRVectors = rVectorPossibilities.allPossibleRVectors(incomingN, incomingTARGET);
        }
        return allPossibleRVectors;
    }


    public void construct()
    {
        construct(n, k, getE(), getF(), TARGET, idealRVector);
    }

    public static void construct(int incomingN, int incomingK, List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int incomingTARGET, int[] incomingIdealRVector)
    {
        fillEWithFUntilDeltaKFull(true, incomingN, incomingK, incomingE, incomingF, incomingIdealRVector); // true = randomly
        step3(incomingN, incomingK, incomingE, incomingF, incomingTARGET);
    }

    private static int[] step3(int incomingN, int incomingK, List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int incomingTARGET)
    {
        int[] currentIdealRVector = new int[incomingN];

        while (incomingE.size() < incomingTARGET)
        {
            ArrayList<Integer> allSizes = new ArrayList<Integer>();

            for (int[] currentRVector : getAllPossibleRVectors(incomingN, incomingTARGET))
            {
                List<Set<Integer>> eDup = new ArrayList<Set<Integer>>(incomingE);
                List<Set<Integer>> fDup = new ArrayList<Set<Integer>>(incomingF);

                fillFWithSelectedElementsOfE(incomingN, incomingK, eDup, fDup, currentRVector); // removes elements from E to F and

                allSizes.add(eDup.size());
            }

            currentIdealRVector = getAllPossibleRVectors(incomingN, incomingTARGET).get(allSizes.indexOf(Collections.max(allSizes)));
            System.out.println("Found an ideal: " + Arrays.toString(currentIdealRVector));
        }

        return currentIdealRVector;
    }

//    public DeltaSystemConstructor(int incomingN, int incomingK, int incomingTARGET, double incomingPercentExclude, Set<Integer> incomingSupport, int[] incomingidealRVector)
//    {
////        n = incomingN;
//        k = incomingK;
//        TARGET = incomingTARGET;
//        percentExclude = incomingPercentExclude;
//        E = new ArrayList<Set<Integer>>();
//        support = incomingSupport;
//        F = new ArrayList<Set<Integer>>(Sets2.getSubsets(support, n));
//        idealRVector = incomingidealRVector;
//
//
//        System.out.println("DeltaSystemConstructor called with primitive fields:");
//        System.out.println('\t' + "n = " + n);
//        System.out.println('\t' + "k = " + k);
//        System.out.println('\t' + "TARGET = " + TARGET);
//        System.out.println('\t' + "percentExclude = " + percentExclude);
//
//        System.out.println("main function called with Set<Set<Integer>> E =");
//        System.out.println("\t" + E);
//        System.out.println("main function called with Set<Integer> support =");
//        System.out.println("\t" + support);
//        System.out.println("main function called with Set<Set<Integer>> F =");
//        System.out.println("\t" + F);
//        System.out.println("main function called with idealRVector idealRVector =");
//        System.out.print("\t[");
//        // printing out ideal r vector (create class and make a toString)
//        for (int i = 0; i < idealRVector.length; i++)
//        {
//            if (i < idealRVector.length - 1)
//                System.out.print(idealRVector[i] + ", ");
//            else
//                System.out.print(idealRVector[i] + "]" + '\n');
//        }
//
//
//        //Step 2 shuffle the sets randomly
//        System.out.println("Step 2");
//        fillEWithFUntilDeltaKFull(true, E, F, idealRVector); // true = randomly
//        System.out.println(E.size());
//
//        //Step 3
//        System.out.println("Step 3");
//        while (E.size() < TARGET)
//        {
//            ArrayList<Integer> allSizes = new ArrayList<Integer>();
//
//            for (int[] currentRVector : getAllPossibleRVectors())
//            {
//                List<Set<Integer>> eDup = new ArrayList<Set<Integer>>(E);
//                List<Set<Integer>> fDup = new ArrayList<Set<Integer>>(F);
//
//                fillFWithSelectedElementsOfE(eDup, fDup, currentRVector, percentExclude); // removes elements from E to F and
//
//                allSizes.add(eDup.size());
//            }
//
//            idealRVector = getAllPossibleRVectors().get(allSizes.indexOf(Collections.max(allSizes)));
//
//        }
//
//        System.out.println("ended with n");
//        System.out.println(n);
//
//        System.out.println("ended with k");
//        System.out.println(k);
//
//        System.out.println("ended with TARGET");
//        System.out.println(TARGET);
//
//        System.out.println("ended with E");
//        System.out.println(E);
//
//        System.out.println("ended with support");
//        System.out.println(support);
//
//        System.out.println("ended with F");
//        System.out.println(F);
//    }

    public static void fillEWithFUntilDeltaKFull(boolean isRandomShuffle, int incomingN, int incomingK, List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int[] incomingRVector)
    {
        if (isRandomShuffle)
        {
            long seed = System.nanoTime();
            Collections.shuffle(incomingF, new Random(seed));
        }
        else
        {
            Collections.sort(incomingF, new rVectorProximityHeuristicComparator(incomingRVector, incomingF, incomingN));
        }

        Set<Set<Integer>> fDup = new HashSet<Set<Integer>>(incomingF);

        for (Set<Integer> f : fDup)
        {

            Set<Integer> actualF = incomingF.get(incomingF.indexOf(f));
            Set<Set<Integer>> union = new HashSet<Set<Integer>>(incomingE);
            union.add(actualF);

            if (Deltas.isDeltaKFree(union, incomingK))
            {
                incomingE.add(actualF);
                incomingF.remove(actualF);
            }
        }
    }



    public static void fillFWithSelectedElementsOfE(int incomingN, int incomingK, List<Set<Integer>> incomingE, List<Set<Integer>> incomingF, int[] incomingIdealRVector)
    {
//        Set<Set<Integer>> eDup = new HashSet<Set<Integer>>(incomingE);
//        Preconditions.checkState(eDup.size() == incomingE.size(), "Duplicating E didn't work properly");
//        Set<Set<Integer>> fDup = new HashSet<Set<Integer>>(incomingF);
//        Preconditions.checkState(fDup.size() == incomingF.size(), "Duplicating F didn't work properly");
//        System.out.println("Starting step 3 with:");
//        System.out.println("\tE of size: " + incomingE.size());
//        System.out.println("\t\t" + incomingE);
//        System.out.println("\tF of size: " + incomingF.size());
//        System.out.println("\t\t" + incomingF);
//        System.out.println("\tIdeal R-Vector of size: " + incomingIdealRVector.length);
//        System.out.println("\t\t" + Arrays.toString(incomingIdealRVector));
//        System.out.println("--------------------------DON'T MIND ME I'M JUST HERE TO DIVIDE THINGS UP--------------------------");


        Collection<Set<Integer>> selectedElements = selectedElements(incomingE, incomingIdealRVector);
        Preconditions.checkState(incomingE.containsAll(selectedElements), "Some of the selected arguments are not in E");

        incomingF.addAll(selectedElements);
        incomingE.removeAll(selectedElements);


        fillEWithFUntilDeltaKFull(false, incomingN, incomingK, incomingE, incomingF, incomingIdealRVector);





//        System.out.println("Ending step 3 with:");
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
//        System.out.println("--------------------------DON'T MIND ME I'M JUST HERE TO DIVIDE THINGS UP--------------------------");
    }

    public static Collection<Set<Integer>> selectedElements(final Collection<Set<Integer>> incomingE, int[] incomingIdealRVector)
    {
        KickOutSelectionPredicate predicate = new KickOutSelectionPredicate(incomingE, incomingIdealRVector);
        return Collections2.filter(incomingE, predicate);
    }


    public static void main(String[] args)
    {
        DeltaSystemConstructor constructor = new DeltaSystemConstructor(3, 3, 20, Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        constructor.construct();
    }
}

class KickOutSelectionPredicate implements Predicate<Set<Integer>>
{
    private final double maxDistance;
    private final Map<Set<Integer>, Double> integerSetDistanceMap;

    public KickOutSelectionPredicate(final Collection<Set<Integer>> incomingE, final int[] incomingIdealRVector)
    {
        super();
        integerSetDistanceMap = new HashMap<Set<Integer>, Double>();

        for (Set<Integer> integerSet : incomingE)
        {
            integerSetDistanceMap.put(integerSet, IntArrays.euclideanDistance(rVectors.rVectorOf(integerSet, incomingE), incomingIdealRVector));
        }

        maxDistance = Collections.max(integerSetDistanceMap.values());
    }


    public boolean apply(final Set<Integer> incomingIntegerSet)
    {
        return (Math.random() * maxDistance / 0.9d) < integerSetDistanceMap.get(incomingIntegerSet);
    }

}