package edu.choate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by dongcarl on 4/22/14.
 */
public class VectorComparator implements Comparator<TreeSet<Integer>>
{
	private static ArrayList<Integer> idealVector;
	private static SetFamily entireSet;
	private static int n;

	public VectorComparator(ArrayList<Integer> incomingIdealVector, SetFamily incomingEntireSet, int incomingN)
	{
		idealVector = incomingIdealVector;
		entireSet = incomingEntireSet;
		n = incomingN;
	}

	@Override
	public int compare(TreeSet<Integer> incomingTreeSetOfInteger1, TreeSet<Integer> incomingTreeSetOfInteger2)
	{
		double distance1 = distanceBetween(idealVector, rVectorOf(incomingTreeSetOfInteger1));
		double distance2 = distanceBetween(idealVector, rVectorOf(incomingTreeSetOfInteger2));

		return Double.compare(distance1, distance2);
	}

	public static ArrayList<Integer> rVectorOf(TreeSet<Integer> f)
	{
		ArrayList<Integer> outgoingRVector = new ArrayList<Integer>();
//		TreeSet<Integer> f = entireSet.get(index);

		for (int i = 0; i <= n - 1; i++)
		{
			int validCounter = 0;
			for (TreeSet<Integer> e : entireSet)
			{
				if (e != f)
				{
					TreeSet<Integer> intersection = new TreeSet<Integer>(f);
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
}
