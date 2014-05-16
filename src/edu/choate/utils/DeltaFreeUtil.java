package edu.choate.utils;

import edu.choate.IntersectionGraph;
import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class DeltaFreeUtil
{
	public static boolean isDeltaKFree(SetFamily setFamily, int k)
	{
        ArrayList<Set<IntegerSet>> allBiggest = allBiggestCliquesOfIntersectionsOf(setFamily);
        boolean stop = false;
        for (int i = 0; i < allBiggest.size() && !stop; i++)
        {
            if (allBiggest.get(i).size() >= k)
            {
                stop = true;
            }
        }
        return !stop;
    }

    public static ArrayList<Set<IntegerSet>> allCliquesOf(SetFamily setFamily)
    {
        ArrayList<Set<IntegerSet>> outgoingCliques = new ArrayList<Set<IntegerSet>>();
        for (IntersectionGraph graph : IntersectionUtils.allFilledIntersectionGraphsOf(setFamily))
        {
            outgoingCliques.addAll(graph.getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static ArrayList<Set<IntegerSet>> allBiggestCliquesOfIntersectionsOf(SetFamily setFamily)
    {
        ArrayList<Set<IntegerSet>> outgoingCliques = new ArrayList<Set<IntegerSet>>();
        for (IntersectionGraph graph : IntersectionUtils.allFilledIntersectionGraphsOf(setFamily))
        {
            outgoingCliques.addAll(graph.getBiggestMaximalCliques());
        }
        return outgoingCliques;
    }

    public static int deltaOf(SetFamily setFamily)
    {
        int outgoingLargestDelta = Integer.MIN_VALUE;
        for (Set<IntegerSet> s : allBiggestCliquesOfIntersectionsOf(setFamily))
        {
            if (s.size() > outgoingLargestDelta)
            {
                outgoingLargestDelta = s.size();
            }
        }
        return outgoingLargestDelta;
    }

	public static void main(String[] args)
	{
		SetFamily setFamily = new SetFamily(3,
				new IntegerSet(1, 2, 3),
				new IntegerSet(1, 2, 4),
				new IntegerSet(1, 2, 5),
				new IntegerSet(1, 3, 4),
				new IntegerSet(1, 3, 5),
				new IntegerSet(1, 4, 5),
				new IntegerSet(1, 6, 7),
				new IntegerSet(1, 6, 8),
				new IntegerSet(1, 6, 9),
				new IntegerSet(1, 7, 8),
				new IntegerSet(1, 7, 9),
				new IntegerSet(1, 8, 9),
				new IntegerSet(1, 10, 11),
				new IntegerSet(1, 10, 12),
				new IntegerSet(1, 10, 13),
				new IntegerSet(1, 11, 12),
				new IntegerSet(1, 12, 13),
				new IntegerSet(1, 11, 13)
		);

		SetFamily setFamily1 = new SetFamily(3,
				new IntegerSet(1, 2, 3),
				new IntegerSet(1, 2, 4),
				new IntegerSet(1, 2, 5),
				new IntegerSet(1, 3, 4),
				new IntegerSet(1, 3, 5),
				new IntegerSet(1, 4, 5),
				new IntegerSet(1, 6, 7),
				new IntegerSet(1, 6, 8),
				new IntegerSet(1, 6, 9),
				new IntegerSet(1, 7, 8),
				new IntegerSet(1, 7, 9),
				new IntegerSet(1, 8, 9),
				new IntegerSet(1, 10, 11),
				new IntegerSet(1, 10, 12),
				new IntegerSet(1, 10, 13),
				new IntegerSet(1, 11, 12),
				new IntegerSet(1, 12, 13),
				new IntegerSet(1, 11, 13)
		);

		for (IntegerSet i : setFamily1)
		{
			for (Integer in : i)
			{
				in += 13;
			}
		}

		SetFamily setFamily2 = new SetFamily(3,
				new IntegerSet(1, 2, 3),
				new IntegerSet(1, 2, 4),
				new IntegerSet(1, 2, 5),
				new IntegerSet(1, 3, 4),
				new IntegerSet(1, 3, 5),
				new IntegerSet(1, 4, 5),
				new IntegerSet(1, 6, 7),
				new IntegerSet(1, 6, 8),
				new IntegerSet(1, 6, 9),
				new IntegerSet(1, 7, 8),
				new IntegerSet(1, 7, 9),
				new IntegerSet(1, 8, 9),
				new IntegerSet(1, 10, 11),
				new IntegerSet(1, 10, 12),
				new IntegerSet(1, 10, 13),
				new IntegerSet(1, 11, 12),
				new IntegerSet(1, 12, 13),
				new IntegerSet(1, 11, 13)
		);

		for (IntegerSet i : setFamily2)
		{
			for (Integer in : i)
			{
				in += 26;
			}
		}

//		setFamily.addAll(setFamily1);
//		setFamily.addAll(setFamily2);

		System.out.println(isDeltaKFree(setFamily, 4));
        System.out.println(deltaOf(setFamily));

	}
}
