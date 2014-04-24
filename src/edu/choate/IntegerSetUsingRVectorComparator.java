package edu.choate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by dongcarl on 4/22/14.
 */
public class IntegerSetUsingRVectorComparator implements Comparator<IntegerSet>
{
	private static rVector idealVector;
	private static SetFamily entireSet;
	private static int n;

	public IntegerSetUsingRVectorComparator(rVector incomingIdealVector, SetFamily incomingEntireSet, int incomingN)
	{
		idealVector = incomingIdealVector;
		entireSet = incomingEntireSet;
		n = incomingN;
	}

	@Override
	public int compare(IntegerSet incomingTreeSetOfInteger1, IntegerSet incomingTreeSetOfInteger2)
	{
		double distance1 = distanceBetween(idealVector, rVectorOf(incomingTreeSetOfInteger1));
		double distance2 = distanceBetween(idealVector, rVectorOf(incomingTreeSetOfInteger2));

		return Double.compare(distance1, distance2);
	}

	public static rVector rVectorOf(IntegerSet f)
	{
		rVector outgoingRVector = new rVector();
//		TreeSet<Integer> f = entireSet.get(index);

		for (int i = 0; i <= n - 1; i++)
		{
			int validCounter = 0;
			for (IntegerSet e : entireSet)
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

	public static double distanceBetween(rVector integerArrayList1, rVector integerArrayList2)
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
