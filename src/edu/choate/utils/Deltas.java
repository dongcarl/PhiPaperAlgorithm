package edu.choate.utils;

import edu.choate.IntersectionGraph;
import edu.choate.TestCases;
import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class Deltas
{
	public static boolean isDeltaKFree(Set<Set<Integer>> setFamily, int k)
	{
        ArrayList<Set<Set<Integer>>> allBiggest = allBiggestCliquesOfIntersectionsOf(setFamily);
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

//	public static boolean isDeltaKFree(ArrayList<Set<Set<Integer>>> allBiggestCliquesOfIntersections, int k)
//	{
//		boolean stop = false;
//		for (int i = 0; i < allBiggestCliquesOfIntersections.size() && !stop; i++)
//		{
//			if (allBiggestCliquesOfIntersections.get(i).size() >= k)
//			{
//				stop = true;
//			}
//		}
//		return !stop;
//	}

    public static ArrayList<Set<Set<Integer>>> allCliquesOf(Set<Set<Integer>> setFamily)
    {
        ArrayList<Set<Set<Integer>>> outgoingCliques = new ArrayList<Set<Set<Integer>>>();
        for (IntersectionGraph graph : Intersections.allFilledIntersectionGraphsOf(setFamily))
        {
	        outgoingCliques.addAll(graph.getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static ArrayList<Set<Set<Integer>>> allBiggestCliquesOfIntersectionsOf(Set<Set<Integer>> setFamily)
    {
        ArrayList<Set<Set<Integer>>> outgoingCliques = new ArrayList<Set<Set<Integer>>>();
        for (IntersectionGraph graph : Intersections.allFilledIntersectionGraphsOf(setFamily))
        {
            outgoingCliques.addAll(graph.getBiggestMaximalCliques());
        }
        return outgoingCliques;
    }

    public static int deltaOf(Set<Set<Integer>> setFamily)
    {
        int outgoingLargestDelta = Integer.MIN_VALUE;
        for (Set<Set<Integer>> s : allBiggestCliquesOfIntersectionsOf(setFamily))
        {
            if (s.size() > outgoingLargestDelta)
            {
                outgoingLargestDelta = s.size();
            }
        }
        return outgoingLargestDelta;
    }

//	public static int deltaOf(ArrayList<Set<Set<Integer>>> allBiggestCliquesOfIntersections)
//	{
//		int outgoingLargestDelta = Integer.MIN_VALUE;
//		for (Set<Set<Integer>> s : allBiggestCliquesOfIntersections)
//		{
//			if (s.size() > outgoingLargestDelta)
//			{
//				outgoingLargestDelta = s.size();
//			}
//		}
//		return outgoingLargestDelta;
//	}

	public static void main(String[] args)
	{
		Set<Set<Integer>> testCase = TestCases.currTest;
		System.out.println(testCase);
		System.out.println(allCliquesOf(testCase));
		System.out.println(isDeltaKFree(testCase, 3));
	}
}
