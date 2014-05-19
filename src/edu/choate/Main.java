package edu.choate;

import com.google.common.collect.Sets;
import edu.choate.structures.*;
import edu.choate.utils.Deltas;
import edu.choate.utils.IntegerSets;

import java.util.*;

public class Main
{

	//Step 1

	static int n = 3;
	static int k = 3;
	static int TARGET = 15;
	static double percentExclude = 0.8;
	static SetList<Set<Integer>> E;
	static Set<Integer> V;
	static SetList<Set<Integer>> F;
	static int[] idealRVector; //need to find ideal R vector


	public static void main(String[] args) throws InterruptedException
	{
		E = new SetList<Set<Integer>>();
		V = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		F = new SetList<Set<Integer>>(IntegerSets.getSubsets(V, n));
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
		for (int i = 0; i < idealRVector.length; i++)
		{
			if (i < idealRVector.length-1)
				System.out.print(idealRVector[i] + ", ");
			else
				System.out.print(idealRVector[i] + "]" + '\n');
		}


	    //Step 2
		step2(true);

	    //Step 3
	    while (E.size() < TARGET)
	    {
		    System.out.println(E.size());
		    Set<Set<Integer>> selectedElements = selectedElements(percentExclude);
		    F.addAll(selectedElements);
		    E.removeAll(selectedElements);

		    step2(false);
	    }

//	    System.out.println("ended with n");
//	    System.out.println(n);
//
//	    System.out.println("ended with k");
//	    System.out.println(k);
//
//	    System.out.println("ended with TARGET");
//	    System.out.println(TARGET);
//
//	    System.out.println("ended with E");
//	    System.out.println(E);
//
//	    System.out.println("ended with V");
//	    System.out.println(V);
//
//	    System.out.println("ended with F");
//	    System.out.println(F);
    }

	public static Set<Set<Integer>> selectedElements(double incomingExclusionPercentage)
	{
		SetList<Set<Integer>> eClone = new SetList<Set<Integer>>(E);
		Collections.sort(eClone, new IntegerSetUsingRVectorComparator(idealRVector, eClone, n));

		int numExcluded = (int)(eClone.size() * incomingExclusionPercentage);

		for (int i = 0; i < numExcluded; i++)
		{
			eClone.removeLast();
		}

		return eClone;
	}


	public static void step2(boolean isRandomShuffle)
	{
		if (isRandomShuffle)
		{
			long seed = System.nanoTime();
			Collections.shuffle(F, new Random(seed));
		}
		else
		{
			Collections.sort(F, new IntegerSetUsingRVectorComparator(idealRVector, F, n));
		}
		// shuffles F


		// iterates through F

		Set<Set<Integer>> dup = new HashSet<Set<Integer>>(F);

		for (Set<Integer> f : dup)
		{


			Set<Integer> actualF = F.get(F.indexOf(f));
			Set<Set<Integer>> union = new HashSet<Set<Integer>>(E);
			union.add(actualF);

			if (Deltas.isDeltaKFree(Sets.union(E, F), k))
			{
				E.add(actualF);
				F.remove(actualF);
			}
		}
	}

}