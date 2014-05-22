package edu.choate;

import com.google.common.collect.Sets;
import edu.choate.learn.rVectorPossibilities;
import edu.choate.learn.rVectorProximityHeuristicComparator;
import edu.choate.utils.Deltas;
import edu.choate.utils.Sets2;

import java.util.*;

public class Main
{

    //Step 1

    static final int n = 3;
    static final int k = 3;
    static int TARGET = 20;
    static double percentExclude = 0.4;
    static ArrayList<Set<Integer>> E;
    static Set<Integer> V;
    static ArrayList<Set<Integer>> F;
    static int[] idealRVector; //need to find ideal R vector
    static ArrayList<int[]> allPossibleRVectors = rVectorPossibilities.allPossibleRVectors(n, TARGET);

    public static void main(String[] args) throws InterruptedException
    {
        E = new ArrayList<Set<Integer>>();
        V = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        F = new ArrayList<Set<Integer>>(Sets2.getSubsets(V, n));
        System.out.println(V);
        idealRVector = new int[]{10, 6, 3};

        System.out.println("main function called with primitive fields:");
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
        step2(true); // true = randomly
        System.out.println(E.size());

        //Step 3
        System.out.println("Step 3");
        while (E.size() < TARGET)
        {
            ArrayList<Integer> allSizes = new ArrayList<Integer>();

            for (int[] currentRVector : allPossibleRVectors)
            {
                HashSet<Set<Integer>> eDup = new HashSet<Set<Integer>>(E);
                HashSet<Set<Integer>> fDup = new HashSet<Set<Integer>>(F);

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

    public static void step2(boolean isRandomShuffle)
    {
        if (isRandomShuffle)
        {
            long seed = System.nanoTime();
            Collections.shuffle(F, new Random(seed));
        } else
        {
            Collections.sort(F, new rVectorProximityHeuristicComparator(idealRVector, F, n));
        }

        Set<Set<Integer>> dup = new HashSet<Set<Integer>>(F);

        for (Set<Integer> f : dup)
        {

            Set<Integer> actualF = F.get(F.indexOf(f));
            Set<Set<Integer>> union = new HashSet<Set<Integer>>(E);
            union.add(actualF);

            if (Deltas.isDeltaKFree(union, k))
            {
                E.add(actualF);
                F.remove(actualF);
            }
        }
    }

    public static void step3Body(Collection<Set<Integer>> incomingE, Collection<Set<Integer>> incomingF, int[] incomingIdealRVector, double incomingPercentExclude)
    {

        System.out.println("↳ E has size: " + incomingE.size());
        ArrayList<Set<Integer>> selectedElements = selectedElements(incomingPercentExclude, incomingE, incomingIdealRVector);
        incomingF.addAll(selectedElements);
        incomingE.removeAll(selectedElements);

        step2(false);
    }

    public static ArrayList<Set<Integer>> selectedElements(double incomingExclusionPercentage, Collection<Set<Integer>> incomingE, int[] incomingIdealRVector)
    {
        ArrayList<Set<Integer>> eClone = new ArrayList<Set<Integer>>(incomingE);
        rVectorProximityHeuristicComparator comparator = new rVectorProximityHeuristicComparator(incomingIdealRVector, eClone, n);
        Collections.sort(eClone, comparator);

        int numExcluded = (int) (eClone.size() * incomingExclusionPercentage);
        System.out.println("Excluding " + numExcluded);
        for (int i = 0; i < numExcluded; i++)
        {
            eClone.remove(eClone.size() - 1);
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