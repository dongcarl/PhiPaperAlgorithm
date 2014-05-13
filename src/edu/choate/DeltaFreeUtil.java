package edu.choate;

/**
 * Created by dongcarl on 5/13/14.
 */
public class DeltaFreeUtil
{
	public static boolean isDeltaK(SetFamily setFamily, int k)
	{
		return setFamily.toIntersectionGraphs().getLargestOfAllBiggestMaximalCliqueNumbers() >= k;
	}
}
