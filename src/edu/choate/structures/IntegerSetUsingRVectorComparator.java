package edu.choate.structures;

import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import edu.choate.utils.IntArrays;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dongcarl on 4/22/14.
 */
public class IntegerSetUsingRVectorComparator implements Comparator<Set<Integer>>
{
	private static int[] idealVector;
	private static SetList<Set<Integer>> entireSet;
	private static int n;

	public IntegerSetUsingRVectorComparator(int[] incomingIdealVector, SetList<Set<Integer>> incomingEntireSet, int incomingN)
	{
		idealVector = incomingIdealVector;
		entireSet = incomingEntireSet;
		n = incomingN;
	}

	@Override
	public int compare(Set<Integer> incomingTreeSetOfInteger1, Set<Integer> incomingTreeSetOfInteger2)
	{
		return Double.compare(IntArrays.euclideanDistance(idealVector, rVectorOf(incomingTreeSetOfInteger1)), IntArrays.euclideanDistance(idealVector, rVectorOf(incomingTreeSetOfInteger2)));
	}

	public static int[] rVectorOf(Set<Integer> f)
	{
		int[] outgoingRVector = new int[n];

		for (int i = 0; i < outgoingRVector.length; i++)
		{
			int currValid = 0;
			for (Set<Integer> e : entireSet)
			{
				if (e != f && Sets.intersection(e, f).size() == i)
				{
					currValid++;
				}
			}
			outgoingRVector[i] = currValid;
		}

		return outgoingRVector;
	}
}
