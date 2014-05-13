package edu.choate;

import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.VertexPair;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by dongcarl on 5/5/14.
 */
public class IntersectionGraphWrapper extends SimpleGraph
{

	public IntegerSet intersection;
	public SimpleGraph<IntegerSet, DefaultEdge> this;

	public IntersectionGraphWrapper(Class<? extends DefaultEdge> edgeClass)
	{
	}

	public void addVertexPairAndGenerateCorrespondingEdge(VertexPair<IntegerSet> incomingPair)
	{
		addVerticesAndGenerateCorrespondingEdge(incomingPair.getFirst(), incomingPair.getSecond());
	}
	
	public boolean addVerticesAndGenerateCorrespondingEdge(IntegerSet vertexA, IntegerSet vertexB)
	{
		boolean methodDidSuceed;
		if (intersection == null)
		{
			intersection = vertexA.intersection(vertexB);
		}

		if (intersection.equals(vertexA.intersection(vertexB)))
		{
			this.addVertex(vertexA);
			this.addVertex(vertexB);
			this.addEdge(vertexA, vertexB);
			methodDidSuceed = true;
		}
		else
		{
			System.out.println("The incomingParameters vertexA: " + vertexA + " and vertexB: " + vertexB + " with intersection: " + vertexA.intersection(vertexB) + " didn't match the intersection " + this.intersection);
			methodDidSuceed = false;
		}

		return methodDidSuceed;
	}

	public IntersectionGraphWrapper(Class<? extends DefaultEdge> edgeClass, ArrayList<VertexPair<IntegerSet>> listOfPairs, IntegerSet representativeIntersection)
	{
		this = new SimpleGraph<IntegerSet, DefaultEdge>(edgeClass);

		intersection = representativeIntersection;

		for (VertexPair<IntegerSet> currPair : listOfPairs)
		{
			this.addVertex(currPair.getFirst());
			this.addVertex(currPair.getSecond());
			this.addEdge(currPair.getFirst(), currPair.getSecond());
		}
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

	public boolean hasSameIntersectionAs(IntersectionGraphWrapper otherGraphWrapper)
	{
		return this.intersection.equals(otherGraphWrapper.intersection);
	}
}
