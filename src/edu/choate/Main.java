package edu.choate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main
{

	//Step 1

	static int n = 3;
	static int k = 3;
	static int TARGET = 15;
	static double percentExclude = 0.8;
	static SetFamily E;
	static IntegerSet V;
	static SetFamily F;
	static idealRVector idealRVector; //need to find ideal R vector


	public static void main(String[] args) throws InterruptedException
	{
		E = new SetFamily();
		V = new IntegerSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		F = kSubsetGenerator.getSubsets(V, n);
		System.out.println(V);
		idealRVector = new idealRVector(n);

	    System.out.println("main function called with primitive fields:");
	    System.out.println('\t' + "n = " + n);
	    System.out.println('\t' + "k = " + k);
	    System.out.println('\t' + "TARGET = " + TARGET);
	    System.out.println('\t' + "percentExclude = " + percentExclude);

	    System.out.println("main function called with SetFamily E =");
	    System.out.println("\t" + E);
	    System.out.println("main function called with IntegerSet V =");
	    System.out.println("\t" + V);
	    System.out.println("main function called with SetFamily F =");
	    System.out.println("\t" + F);
	    System.out.println("main function called with idealRVector idealRVector =");
	    System.out.println("\t" + idealRVector);

	    //Step 2
		step2(true);

	    //Step 3
	    while (E.size() < TARGET)
	    {
		    System.out.println(E.size());
		    SetFamily selectedElements = selectedElements(percentExclude);
		    F.addAll(selectedElements);
		    E.removeAll(selectedElements);

		    step2(false);
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

	public static SetFamily selectedElements(double incomingExclusionPercentage)
	{
		SetFamily eClone = new SetFamily(n, E);
		Collections.sort(eClone, new IntegerSetUsingRVectorComparator(idealRVector, eClone, n));

		int numExcluded = (int)(eClone.size() * incomingExclusionPercentage);

		for (int i = 0; i < numExcluded; i++)
		{
			eClone.pop();
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

		ArrayList<ArrayList<Integer>> dup = new ArrayList<ArrayList<Integer>>(F);

		for (ArrayList<Integer> f : dup)
		{
			IntegerSet actualF = F.get(F.indexOf(f));
			SetFamily union = new SetFamily(n, E);
			union.add(actualF);

			if (!DeltaFreeSystem.containsDelta(k, union))
			{
				E.add(actualF);
				F.remove(actualF);
			}
		}
	}

}