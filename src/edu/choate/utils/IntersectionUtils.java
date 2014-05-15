package edu.choate.utils;

import edu.choate.structures.IntegerSet;
import edu.choate.IntersectionGraph;
import edu.choate.structures.SetFamily;

import java.util.ArrayList;

/**
 * Created by dongcarl on 5/13/14.
 */
public class IntersectionUtils
{
	public static SetFamily allIntersectionsOf(SetFamily setFamily)
	{
		SetFamily outgoingIntersections = new SetFamily();

		for (int i = 0; i < setFamily.size(); i++)
		{
			for (int v = i; v < setFamily.size(); v++)
			{
				outgoingIntersections.add(setFamily.get(i).intersection(setFamily.get(v)));
			}
		}

		return outgoingIntersections;
	}

	public static ArrayList<IntersectionGraph> allEmptyIntersectionGraphsOf(SetFamily setFamily)
	{
        ArrayList<IntersectionGraph> outgoingIntersectionGraphs = new ArrayList<IntersectionGraph>();

        for (IntegerSet currIntersection : allIntersectionsOf(setFamily))
        {
            outgoingIntersectionGraphs.add(new IntersectionGraph(currIntersection));
        }

        return outgoingIntersectionGraphs;
	}

    public static ArrayList<IntersectionGraph> allFilledIntersectionGraphsOf(SetFamily setFamily)
    {
        ArrayList<IntersectionGraph> outgoingFilledIntersectionGraphs = new ArrayList<IntersectionGraph>(allEmptyIntersectionGraphsOf(setFamily));

        for (int i = 0; i < setFamily.size(); i++)
        {
            for (int j = 0; j < setFamily.size(); j++)
            {
                for (IntersectionGraph graph : outgoingFilledIntersectionGraphs)
                {
                    graph.addVerticesAndGenerateCorrespondingEdge(setFamily.get(i), setFamily.get(j));
                }
            }
        }

        return outgoingFilledIntersectionGraphs;
    }
}
