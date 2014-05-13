package edu.choate;

import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;

/**
 * Created by dongcarl on 5/5/14.
 */
public class IntersectionGraphFamilyWrapper
{
	private ArrayList<IntersectionGraphWrapper> wrappedIntersectionGraphFamily;

	public IntersectionGraphFamilyWrapper()
	{
		wrappedIntersectionGraphFamily = new ArrayList<IntersectionGraphWrapper>();
	}

//	/**
//	 * Adds an intersection of two vertices to a list of intersections
//	 *
//	 * Uses {@link IntersectionGraphWrapper#addVerticesAndGenerateCorrespondingEdge(IntegerSet, IntegerSet)} to try to add {@param vertexA} and {@param vertexB} to an existing {@link edu.choate.IntersectionGraphWrapper} with the same {link IntersectionGraphWrapper#intersection} and create an {@link org.jgrapht.graph.DefaultEdge}, if unsuccessful, creates a new {@link edu.choate.IntersectionGraphWrapper} from the intersection of {@param vertexA} and {@param vertexB} and adds it to {@link #wrappedIntersectionGraphFamily}
//	 *
//	 * @param   vertexA     the first vertex to generate the intersection from
//	 * @param   vertexB     the second vertex to generate the intersection from
//	 *
//	 * @return true if the intersection of {@param vertexA} and {@param vertexB} wasn't present in {@link #wrappedIntersectionGraphFamily} and a new {@link edu.choate.IntersectionGraphWrapper} was created, false if the intersection of {@param vertexA} and {@param vertexB} was present in {@link #wrappedIntersectionGraphFamily}
//	 */

	public boolean addVertices(IntegerSet vertexA, IntegerSet vertexB)
	{
		System.out.println("Attempting to add vertices " + vertexA + " and " + vertexB + " with intersection " + vertexA.intersection(vertexB));
		boolean didGetAddedToAnyIntersectionGraph = false;
		boolean didCreateNewInterSectionGraph = false;

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
			didCreateNewInterSectionGraph = true;
			System.out.println("It didn't get added to any intersection graphs! Meaning it has a unique intersection that needs its own intersection graph!");
			IntersectionGraphWrapper newIntersectionGraph = new IntersectionGraphWrapper(DefaultEdge.class);
			wrappedIntersectionGraphFamily.add(newIntersectionGraph);
			newIntersectionGraph.addVerticesAndGenerateCorrespondingEdge(vertexA, vertexB);
		}

		return didCreateNewInterSectionGraph;
	}

	public boolean addIntersection()

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
