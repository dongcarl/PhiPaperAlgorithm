package edu.choate;

import com.google.common.collect.Sets;
import edu.choate.structures.IntegerSet;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.VertexPair;

import java.util.Collection;
import java.util.Set;

/**
 * Created by dongcarl on 5/5/14.
 */
public class IntersectionGraph extends SimpleGraph<Set<Integer>, DefaultEdge>
{

	public Set<Integer> intersection;

    public IntersectionGraph()
    {
        super(DefaultEdge.class);
    }

    public IntersectionGraph(Set<Integer> incomingIntersection)
    {
        super(DefaultEdge.class);
        intersection = incomingIntersection;
    }

	public void addVertexPairAndGenerateCorrespondingEdge(VertexPair<Set<Integer>> incomingPair)
	{
		addVerticesAndGenerateCorrespondingEdge(incomingPair.getFirst(), incomingPair.getSecond());
	}
	
	public boolean addVerticesAndGenerateCorrespondingEdge(Set<Integer> vertexA, Set<Integer> vertexB)
	{
//        System.out.println("adding: " + vertexA + " and " + vertexB);

		boolean methodDidSucceed;
		if (intersection == null)
		{
			intersection = Sets.intersection(vertexA, vertexB);
		}

//        System.out.println("Going to compare: " + intersection + " with " + vertexA.intersection(vertexB));

		if (intersection.equals(Sets.intersection(vertexA, vertexB)))
		{
            this.addVertex(vertexA);
			this.addVertex(vertexB);
			this.addEdge(vertexA, vertexB);
			methodDidSucceed = true;
		}
		else
		{
//			System.out.println("The incomingParameters vertexA: " + vertexA + " and vertexB: " + vertexB + " with intersection: " + vertexA.intersection(vertexB) + " didn't match the intersection " + this.intersection);
			methodDidSucceed = false;
		}

		return methodDidSucceed;
	}

	public int getBiggestMaximalCliqueNumber()
	{
//		System.out.println("The IntersectionGraph looks like this: " + this);
//		System.out.println("getBiggestMaximalCliques returns: " + cliqueFinder().getBiggestMaximalCliques());
		return cliqueFinder().getBiggestMaximalCliques().iterator().next().size();
	}

	public Collection<Set<Set<Integer>>> getAllMaximalCliques()
	{
		return cliqueFinder().getAllMaximalCliques();
	}

	public Collection<Set<Set<Integer>>> getBiggestMaximalCliques()
	{
		return cliqueFinder().getBiggestMaximalCliques();
	}

	public BronKerboschCliqueFinder<Set<Integer>, DefaultEdge> cliqueFinder()
	{
		return new BronKerboschCliqueFinder<Set<Integer>, DefaultEdge>(this);
	}

	public boolean hasSameIntersectionAs(IntersectionGraph otherGraphWrapper)
	{
		return this.intersection.equals(otherGraphWrapper.intersection);
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean outgoingEqualsDecision = false;
		if (obj instanceof IntersectionGraph)
		{
			IntersectionGraph incomingIntersectionGraph = (IntersectionGraph)obj;
			boolean hasSameIntersection = this.intersection.equals(incomingIntersectionGraph.intersection);
			boolean isSuperEquals = super.equals(obj);
			outgoingEqualsDecision = hasSameIntersection && isSuperEquals;
		}
		return outgoingEqualsDecision;
	}
}
