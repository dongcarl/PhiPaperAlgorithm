package edu.choate;

import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;

/**
 * Created by dongcarl on 4/29/14.
 */
public class IntersectionEdge extends DefaultEdge
{
	static Intersection wrappedIntersection;
	public HashSet<IntegerSetVertex> vertices;

	public IntersectionEdge(Intersection incomingIntersection)
	{
		super();
		wrappedIntersection = incomingIntersection;
		for (IntegerSet i : incomingIntersection.sets)
		{
			vertices.add(new IntegerSetVertex(i));
		}
	}
}
