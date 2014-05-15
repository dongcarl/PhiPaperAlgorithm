package edu.choate.utils;

import edu.choate.IntersectionGraph;
import edu.choate.SetFamily;

/**
 * Created by dongcarl on 5/13/14.
 */
public class DeltaFreeUtil
{
	public static boolean isDeltaK(SetFamily setFamily, int k)
	{
		return deltaOf(setFamily) >= k;
	}

    public static int deltaOf(SetFamily setFamily)
    {
        int currLargestDelta = Integer.MIN_VALUE;
        for (IntersectionGraph graph : IntersectionUtils.allFilledIntersectionGraphsOf(setFamily))
        {
            if (graph.getBiggestMaximalCliqueNumber() > currLargestDelta)
            {
                currLargestDelta = graph.getBiggestMaximalCliqueNumber();
            }
        }
        return currLargestDelta;
    }
}
