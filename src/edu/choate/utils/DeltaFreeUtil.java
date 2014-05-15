package edu.choate.utils;

import edu.choate.IntersectionGraph;
import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

/**
 * Created by dongcarl on 5/13/14.
 */
public class DeltaFreeUtil
{
	public static boolean isDeltaKFree(SetFamily setFamily, int k)
	{
		return !(deltaOf(setFamily) >= k);
	}

    public static int deltaOf(SetFamily setFamily)
    {
        int currLargestDelta = Integer.MIN_VALUE;
        for (IntersectionGraph graph : IntersectionUtils.allFilledIntersectionGraphsOf(setFamily))
        {
	        System.out.println("the current graph has maximal clique number: " + graph.getBiggestMaximalCliqueNumber());
	        if (graph.getBiggestMaximalCliqueNumber() > currLargestDelta)
            {
                currLargestDelta = graph.getBiggestMaximalCliqueNumber();
            }
        }
        return currLargestDelta;
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

	}
}
