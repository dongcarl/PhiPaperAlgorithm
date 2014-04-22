package edu.choate;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.Integer;

public class Main
{

    public static void main(String[] args)
    {
        //Step 1
        // this is declaring the inputs of Phi(n,k)
	    int n = 3;
	    int k = 3;

	    int TARGET = 10;

		ArrayList<ArrayList<Integer>> E = new ArrayList<ArrayList<Integer>>();

	    ArrayList<Integer> V = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));

	    // The next line has a big big O and we should find a more efficient alternative
	    ArrayList<ArrayList<Integer>> F = allSubsets(V, n);

	    //Step 2
		step2(F, E, k, n, true);

	    //Step 3
	    while (E.size() < TARGET)
	    {
		    System.out.println(E.size());
		    ArrayList<ArrayList<Integer>> selectedElements = selectedElements(E, n);
		    F.addAll(selectedElements);
		    E.removeAll(selectedElements);

		    step2(F, E, k, n, false);
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


//	    Set<ArrayList> arr = new HashSet<ArrayList>(Arrays.asList(
//			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(2), new Integer(3))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(3), new Integer(4))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(4), new Integer(5))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(5), new Integer(6))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(3), new Integer(5))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(4), new Integer(5))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(4), new Integer(6))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(3), new Integer(2), new Integer(6))),
//			    new ArrayList<Integer>(Arrays.asList(new Integer(3), new Integer(5), new Integer(6)))
//
//	    ));
//
//	    Set subsets = allSubsets(arr, 3);
//
//	    System.out.println(subsets);
//	    System.out.println("and it has size of: " + subsets.size());

    }

	public static ArrayList<ArrayList<Integer>> selectedElements(ArrayList<ArrayList<Integer>> incomingE, int incomingN)
	{
		ArrayList<ArrayList<Integer>> orderedE = orderArrayListUsingRVectors(incomingE, allRVectors(incomingE, incomingN));
		ArrayList<ArrayList<Integer>> backupOrderedE = new ArrayList<ArrayList<Integer>>(orderedE);

		for (int i = backupOrderedE.size()-1; i >= (3.0/4)*backupOrderedE.size(); i--)
		{
			orderedE.remove(backupOrderedE.get(i));
		}

		return orderedE;








//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//		ArrayList<ArrayList<Integer>> dup = new ArrayList<ArrayList<Integer>>(incomingE);
//
//		int Min = 0;
//		int Max = dup.size() - 1;
//
//		int howmany = Min + (int)(Math.random() * ((Max - Min) + 1));
//
//		for (long i = 0; i < howmany; i++)
//		{
//			int whichone = Min + (int)(Math.random() * ((Max - Min) + 1));
//			list.add(dup.get(whichone));
//			dup.remove(dup.get(whichone));
//			Max = dup.size() - 1;
//		}
//
//		return list;
	}

	public static ArrayList<ArrayList<Integer>> allRVectors(ArrayList<ArrayList<Integer>> incomingE, int incomingN)
	{
		ArrayList<ArrayList<Integer>> allRs = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < incomingE.size(); i++)
		{
			allRs.add(rVectorOf(incomingE, i, incomingN));
		}

		return allRs;
	}


	public static ArrayList<Integer> rVectorOf(ArrayList<ArrayList<Integer>> incomingE, int index, int incomingN)
	{
		ArrayList<Integer> outgoingRVector = new ArrayList<Integer>();
		ArrayList<Integer> f = incomingE.get(index);

		for (int i = 0; i <= incomingN - 1; i++)
		{
			int validCounter = 0;
			for (ArrayList<Integer> e : incomingE)
			{
				if (e != f)
				{
					ArrayList<Integer> intersection = new ArrayList<Integer>(f);
					intersection.retainAll(e);

					if (intersection.size() == i)
					{
						validCounter++;
					}
				}
			}
			outgoingRVector.add(validCounter);
		}

		return outgoingRVector;
	}

	public static void step2(ArrayList<ArrayList<Integer>> F, ArrayList<ArrayList<Integer>> E, int k, int n, boolean isRandomShuffle)
	{
		if (isRandomShuffle)
		{
			long seed = System.nanoTime();
			Collections.shuffle(F, new Random(seed));
		}
		else
		{
			F = orderArrayListUsingRVectors(F, allRVectors(F, n));
		}
		// shuffles F


		// iterates through F

		ArrayList<ArrayList<Integer>> dup = new ArrayList<ArrayList<Integer>>(F);

		for (ArrayList<Integer> f : dup)
		{
			ArrayList<Integer> actualF = F.get(F.indexOf(f));
			ArrayList<ArrayList<Integer>> union = new ArrayList<ArrayList<Integer>>(E);
			union.add(actualF);

			if (!containDelta(union, k))
			{
				E.add(actualF);
				F.remove(actualF);
			}
		}
	}




	public static boolean containDelta(ArrayList<ArrayList<Integer>> incomingSet, int incomingK)
	{
		intersectionGrid intersectionGrid = new intersectionGrid();

		for (int i = 0; i < incomingSet.size(); i++)
		{
			for (int v = i+1; v < incomingSet.size(); v++)
			{
				ArrayList<Integer> s1 = incomingSet.get(i);
				ArrayList<Integer> s2 = incomingSet.get(v);

				ArrayList<Integer> intersection = new ArrayList<Integer>(s1);
				intersection.retainAll(s2);

				int currInd = intersectionGrid.intersections.indexOf(intersection);

				if (currInd == -1)
				{
					intersectionGrid.intersections.add(intersection);
					intersectionGrid.numIntersected.add(1);
				}
				else
				{
					intersectionGrid.numIntersected.set(currInd, intersectionGrid.numIntersected.get(currInd) + 1);
				}

			}
		}

		long max;
		if (intersectionGrid.numIntersected.size() == 0)
		{
			max = 0;
		}
		else
		{
			max = Collections.max(intersectionGrid.numIntersected);
		}

		return max >= choose(incomingK, 2);
	}

	public static long choose(long m, long k)
	{
		return (factorial(m))/(factorial(k) * factorial(m-k));
	}

	public static long factorial(long n)
	{
		long fact = 1; // this  will be the result
		for (long i = 1; i <= n; i++)
		{
			fact *= i;
		}
		return fact;
	}

	// Takes in V, the ArrayList of elements, and n, how many elements we need
	public static ArrayList<ArrayList<Integer>> allSubsets(ArrayList<Integer> incomingArrayList, int incomingNumberOfElements)
	{
		ArrayList<ArrayList<Integer>> outgoingArrayList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> powerSet = powerSet(incomingArrayList);

		for (ArrayList<Integer> set : powerSet)
		{
			if (set.size() == incomingNumberOfElements)
			{
				outgoingArrayList.add(set);
			}
		}

		return outgoingArrayList;
	}

	static public <T> ArrayList<ArrayList<T>> powerSet(ArrayList<T> inputSet) {
		ArrayList<ArrayList<T>> resultPowerSet = new ArrayList<ArrayList<T>>();

		if (inputSet.isEmpty()) {
			resultPowerSet.add(new ArrayList<T>());
			return resultPowerSet;
		}

		T headElement = inputSet.remove(0);
		ArrayList<ArrayList<T>> tailPowerSet = powerSet(inputSet);
		resultPowerSet.addAll(tailPowerSet);
		for (ArrayList<T> tailSet : tailPowerSet) {
			ArrayList<T> headSet = new ArrayList<T>(tailSet);
			headSet.add(headElement);
			resultPowerSet.add(headSet);
		}
		return resultPowerSet;
	}

	public static double distanceBetween(ArrayList<Integer> integerArrayList1, ArrayList<Integer> integerArrayList2)
	{
		long sum = 0;

		if (integerArrayList1.size() == integerArrayList2.size())
		{
			for (int i = 0; i < integerArrayList1.size(); i++)
			{
				sum += (integerArrayList1.get(i) - integerArrayList2.get(i)) * (integerArrayList1.get(i) - integerArrayList2.get(i));
			}
		}

		return Math.sqrt(sum);
	}

	public static ArrayList<Double> allDistancesFrom(ArrayList<Integer> integerArrayList1, ArrayList<ArrayList<Integer>> integerArrayList2)
	{
		ArrayList<Double> outgoingAllDistances = new ArrayList<Double>();

		for (int i = 0; i < integerArrayList2.size(); i++)
		{
			outgoingAllDistances.add(distanceBetween(integerArrayList2.get(i), integerArrayList1));
		}

		return outgoingAllDistances;
	}

	public static ArrayList<ArrayList<Integer>> orderArrayListUsingRVectors(ArrayList<ArrayList<Integer>> incomingArrayList, ArrayList<ArrayList<Integer>> allRVectors)
	{
		ArrayList<Double> distanceArray = allDistancesFrom(new ArrayList<Integer>(), allRVectors);
		ArrayList<Double> backupDistanceArray = new ArrayList<Double>(distanceArray);
		ArrayList<ArrayList<Integer>> sortedIncomingArrayList = new ArrayList<ArrayList<Integer>>();

		if (incomingArrayList.size() == distanceArray.size())
		{
			Collections.sort(distanceArray);

			for (int i = 0; i < distanceArray.size(); i++)
			{
				double d = distanceArray.get(i);
				int indexOfDInBackup = backupDistanceArray.indexOf(d);

				sortedIncomingArrayList.add(incomingArrayList.get(indexOfDInBackup));
			}
		}

		return sortedIncomingArrayList;
	}




}

class intersectionGrid
{
	ArrayList<List> intersections;
	ArrayList<Integer> numIntersected;

	public intersectionGrid()
	{
		intersections = new ArrayList<List>();
		numIntersected = new ArrayList<Integer>();
	}
}

