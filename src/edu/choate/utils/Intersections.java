package edu.choate.utils;

import edu.choate.IntersectionGraph;
import edu.choate.TestCases;
import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class Intersections
{
	public static Set<IntegerSet> allIntersectionsOf(SetFamily setFamily)
	{
		Set<IntegerSet> outgoingIntersections = new HashSet<IntegerSet>(setFamily.n);

		for (int i = 0; i < setFamily.size(); i++)
		{
			for (int v = i + 1; v < setFamily.size(); v++)
			{
                outgoingIntersections.add(setFamily.get(i).intersection(setFamily.get(v)));
            }
		}

		return outgoingIntersections;
	}

	public static Set<IntersectionGraph> allEmptyIntersectionGraphsOf(SetFamily setFamily)
	{
		Set<IntersectionGraph> outgoingIntersectionGraphs = new HashSet<IntersectionGraph>();

        for (IntegerSet currIntersection : allIntersectionsOf(setFamily))
        {
	        outgoingIntersectionGraphs.add(new IntersectionGraph(currIntersection));
        }

        return outgoingIntersectionGraphs;
	}

    public static Set<IntersectionGraph> allFilledIntersectionGraphsOf(SetFamily setFamily)
    {
	    Set<IntersectionGraph> outgoingFilledIntersectionGraphs = new HashSet<IntersectionGraph>(allEmptyIntersectionGraphsOf(setFamily));

        for (int i = 0; i < setFamily.size(); i++)
        {
            for (int j = i + 1; j < setFamily.size(); j++)
            {
                for (IntersectionGraph graph : outgoingFilledIntersectionGraphs)
                {
                    graph.addVerticesAndGenerateCorrespondingEdge(setFamily.get(i), setFamily.get(j));
                }
            }
        }

        return outgoingFilledIntersectionGraphs;
    }

	public static void main(String[] args)
	{
		System.out.println("Testing: public static ArrayList<IntegerSet> allIntersectionsOf(SetFamily setFamily)");
		System.out.println("↳ outputted: " + allIntersectionsOf(TestCases.deltaN2K3Free2));
		System.out.println("↳ expected: " + new SetFamily(
				3,
				new IntegerSet(3),
				new IntegerSet(1),
				new IntegerSet(2)
		));
		System.out.println("↳ .equals says: " + allIntersectionsOf(TestCases.deltaN2K3Free2).equals(new SetFamily(
				3,
				new IntegerSet(3),
				new IntegerSet(1),
				new IntegerSet(2)
		)));

	}


}
