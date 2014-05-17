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

//	public static boolean isDeltaKFree(ArrayList<Set<IntegerSet>> allBiggestCliquesOfIntersections, int k)
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

    public static ArrayList<Set<IntegerSet>> allCliquesOf(SetFamily setFamily)
    {
        ArrayList<Set<IntegerSet>> outgoingCliques = new ArrayList<Set<IntegerSet>>();
        for (IntersectionGraph graph : Intersections.allFilledIntersectionGraphsOf(setFamily))
        {
	        outgoingCliques.addAll(graph.getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static ArrayList<Set<IntegerSet>> allBiggestCliquesOfIntersectionsOf(SetFamily setFamily)
    {
        ArrayList<Set<IntegerSet>> outgoingCliques = new ArrayList<Set<IntegerSet>>();
        for (IntersectionGraph graph : Intersections.allFilledIntersectionGraphsOf(setFamily))
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

//	public static int deltaOf(ArrayList<Set<IntegerSet>> allBiggestCliquesOfIntersections)
//	{
//		int outgoingLargestDelta = Integer.MIN_VALUE;
//		for (Set<IntegerSet> s : allBiggestCliquesOfIntersections)
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
		SetFamily testCase = TestCases.deltaN3K3Free;
		System.out.println(testCase);
		System.out.println(allCliquesOf(testCase));
	}
}
