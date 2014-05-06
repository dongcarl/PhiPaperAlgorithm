package edu.choate;

import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;

/**
 * Created by dongcarl on 5/5/14.
 */
public class IntersectionGraphFamilyWrapper
{
	ArrayList<IntersectionGraphWrapper> wrappedIntersectionGraphFamily;

	public IntersectionGraphFamilyWrapper()
	{
		wrappedIntersectionGraphFamily = new ArrayList<IntersectionGraphWrapper>();
	}

	public void attemptToAddVertices(IntegerSet vertexA, IntegerSet vertexB)
	{
		System.out.println("Attempting to add vertices " + vertexA + " and " + vertexB + " with intersection " + vertexA.intersection(vertexB));
		boolean didGetAddedToAnyIntersectionGraph = false;

		for (int i = 0; i < wrappedIntersectionGraphFamily.size() && !didGetAddedToAnyIntersectionGraph; i++)
		{
			IntersectionGraphWrapper currIntersectionGraph = wrappedIntersectionGraphFamily.get(i);
			if (currIntersectionGraph.addVerticesAndGenerateCorrespondingEdge(vertexA, vertexB))
			{
				System.out.println("It did match " + currIntersectionGraph.intersection + " going to be added...");
				didGetAddedToAnyIntersectionGraph = true;
			}
		}

		if (!didGetAddedToAnyIntersectionGraph)
		{
			System.out.println("It didn't get added to any intersection graphs! Meaning it has a unique intersection that needs its own intersection graph!");
			IntersectionGraphWrapper newIntersectionGraph = new IntersectionGraphWrapper(DefaultEdge.class);
			wrappedIntersectionGraphFamily.add(newIntersectionGraph);
			newIntersectionGraph.addVerticesAndGenerateCorrespondingEdge(vertexA, vertexB);
		}
	}

	public int getLargestOfAllBiggestMaximalCliqueNumbers()
	{
		int currLargest = Integer.MIN_VALUE;
		for (IntersectionGraphWrapper i : wrappedIntersectionGraphFamily)
		{
			System.out.println("Going to check if " + i.getBiggestMaximalCliqueNumber() + " is larger than " + currLargest);
			if (i.getBiggestMaximalCliqueNumber() > currLargest)
			{
				currLargest = i.getBiggestMaximalCliqueNumber();
			}
		}
		return currLargest;
	}
}
