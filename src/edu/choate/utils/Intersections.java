package edu.choate.utils;

import com.google.common.collect.Sets;
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
	public static Set<Set<Integer>> allIntersectionsOf(Set<Set<Integer>> setFamily)
	{
		Set<Set<Integer>> outgoingIntersections = new HashSet<Set<Integer>>(/*setFamily.n*/);

		ArrayList<Set<Integer>> arrayList = new ArrayList<Set<Integer>>(setFamily);

		for (int i = 0; i < arrayList.size(); i++)
		{
			for (int v = i + 1; v < arrayList.size(); v++)
			{
                outgoingIntersections.add(Sets.intersection(arrayList.get(i), arrayList.get(v)));
            }
		}

		return outgoingIntersections;
	}

	public static Set<IntersectionGraph> allEmptyIntersectionGraphsOf(Set<Set<Integer>> setFamily)
	{
		Set<IntersectionGraph> outgoingIntersectionGraphs = new HashSet<IntersectionGraph>();

        for (Set<Integer> currIntersection : allIntersectionsOf(setFamily))
        {
	        outgoingIntersectionGraphs.add(new IntersectionGraph(currIntersection));
        }

        return outgoingIntersectionGraphs;
	}

    public static Set<IntersectionGraph> allFilledIntersectionGraphsOf(Set<Set<Integer>> setFamily)
    {
	    Set<IntersectionGraph> outgoingFilledIntersectionGraphs = new HashSet<IntersectionGraph>(allEmptyIntersectionGraphsOf(setFamily));

	    ArrayList<Set<Integer>> arrayList = new ArrayList<Set<Integer>>(setFamily);

	    for (int i = 0; i < arrayList.size(); i++)
        {
            for (int j = i + 1; j < arrayList.size(); j++)
            {
                for (IntersectionGraph graph : outgoingFilledIntersectionGraphs)
                {
                    graph.addVerticesAndGenerateCorrespondingEdge(arrayList.get(i), arrayList.get(j));
                }
            }
        }

        return outgoingFilledIntersectionGraphs;
    }

	public static void main(String[] args)
	{
		System.out.println("Testing: public static ArrayList<Set<Integer>> allIntersectionsOf(Set<Set<Integer>> setFamily)");
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
