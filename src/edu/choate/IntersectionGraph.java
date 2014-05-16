package edu.choate;

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
public class IntersectionGraph extends SimpleGraph<IntegerSet, DefaultEdge>
{

	public IntegerSet intersection;

    public IntersectionGraph()
    {
        super(DefaultEdge.class);
    }

    public IntersectionGraph(IntegerSet incomingIntersection)
    {
        super(DefaultEdge.class);
        intersection = incomingIntersection;
    }

	public void addVertexPairAndGenerateCorrespondingEdge(VertexPair<IntegerSet> incomingPair)
	{
		addVerticesAndGenerateCorrespondingEdge(incomingPair.getFirst(), incomingPair.getSecond());
	}
	
	public boolean addVerticesAndGenerateCorrespondingEdge(IntegerSet vertexA, IntegerSet vertexB)
	{
        System.out.println("adding: " + vertexA + " and " + vertexB);

		boolean methodDidSucceed;
		if (intersection == null)
		{
			intersection = vertexA.intersection(vertexB);
		}

        System.out.println("Going to compare: " + intersection + " with " + vertexA.intersection(vertexB));

		if (intersection.equals(vertexA.intersection(vertexB)))
		{
            this.addVertex(vertexA);
			this.addVertex(vertexB);
			this.addEdge(vertexA, vertexB);
			methodDidSucceed = true;
		}
		else
		{
			System.out.println("The incomingParameters vertexA: " + vertexA + " and vertexB: " + vertexB + " with intersection: " + vertexA.intersection(vertexB) + " didn't match the intersection " + this.intersection);
			methodDidSucceed = false;
		}

		return methodDidSucceed;
	}

	public int getBiggestMaximalCliqueNumber()
	{
		System.out.println("The IntersectionGraph looks like this: " + this);
		System.out.println("getBiggestMaximalCliques returns: " + cliqueFinder().getBiggestMaximalCliques());
		return cliqueFinder().getBiggestMaximalCliques().iterator().next().size();
	}

	public Collection<Set<IntegerSet>> getAllMaximalCliques()
	{
		return cliqueFinder().getAllMaximalCliques();
	}

	public Collection<Set<IntegerSet>> getBiggestMaximalCliques()
	{
		return cliqueFinder().getBiggestMaximalCliques();
	}

	public BronKerboschCliqueFinder<IntegerSet, DefaultEdge> cliqueFinder()
	{
		return new BronKerboschCliqueFinder<IntegerSet, DefaultEdge>(this);
	}

	public boolean hasSameIntersectionAs(IntersectionGraph otherGraphWrapper)
	{
		return this.intersection.equals(otherGraphWrapper.intersection);
	}
}
