package edu.choate;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.Integer;

public class Main
{

    public static void main(String[] args)
    {

	    //Step 1
	    int n, k, TARGET;

		ArrayList E = new ArrayList();

	    ArrayList V = new ArrayList();
	    ArrayList F = allSubsets(V, n);

	    //Step 2
		step2(F, E, k);

	    //Step 3
	    while (E.size() < TARGET)
	    {
		    Set selectedElements = selectedElements(E);
		    F.addAll(selectedElements);
		    E.removeAll(selectedElements);

		    step2(F, E, k);
	    }


	    Set<ArrayList> arr = new HashSet<ArrayList>(Arrays.asList(
			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(2), new Integer(3))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(3), new Integer(4))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(4), new Integer(5))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(1), new Integer(5), new Integer(6))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(3), new Integer(5))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(4), new Integer(5))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(2), new Integer(4), new Integer(6))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(3), new Integer(2), new Integer(6))),
			    new ArrayList<Integer>(Arrays.asList(new Integer(3), new Integer(5), new Integer(6)))

	    ));

	    Set subsets = allSubsets(arr, 3);

	    System.out.println(subsets);
	    System.out.println("and it has size of: " + subsets.size());

    }

	public static void step2(List F, List E, int k)
	{
		long seed = System.nanoTime();
		Collections.shuffle(F, new Random(seed));

		for (Set f : F)
		{
			Set union = new HashSet(E);
			union.addAll(f);

			if (!containDelta(union, k))
			{
				E.add(f);
				F.remove(f);
			}
		}
	}

	// Takes in V, the ArrayList of elements, and n, how many elements we need
	public static <T> Set<Set<T>> allSubsets(Set<T> incomingArrayList, int incomingNumberOfElements)
	{
		HashSet<Set<T>> outgoingArrayList = new HashSet<Set<T>>();
		Set<Set<T>> powerSet = powerSet(incomingArrayList);

		for (Set<T> set : powerSet)
		{
			if (set.size() == incomingNumberOfElements)
			{
				outgoingArrayList.add(set);
			}
		}

		return outgoingArrayList;
	}

	public static <T> Set<Set<T>> powerSet(Set<T> originalSet)
	{
		Set<Set<T>> sets = new HashSet<Set<T>>();
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<T>());
			return sets;
		}
		List<T> list = new ArrayList<T>(originalSet);
		T head = list.get(0);
		Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
		for (Set<T> set : powerSet(rest)) {
			Set<T> newSet = new HashSet<T>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}
}
