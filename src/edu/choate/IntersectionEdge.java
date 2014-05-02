package edu.choate;

import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;

/**
 * Created by dongcarl on 4/29/14.
 */
public class IntersectionEdge extends DefaultEdge
{
	static Intersection wrappedIntersection;
    public IntegerSetVertex alphaVertex;
    public IntegerSetVertex betaVertex;

	public IntersectionEdge(Intersection incomingIntersection)
	{
		super();
		wrappedIntersection = incomingIntersection;
//		for (IntegerSet i : incomingIntersection.sets)
//		{
//            System.out.println("Going to add: " + new IntegerSetVertex(i) + " with IntegerSet: " + i);
//			vertices.add(new IntegerSetVertex(i));
//		}
        
        alphaVertex = new IntegerSetVertex(incomingIntersection.alphaSet);
        betaVertex = new IntegerSetVertex(incomingIntersection.betaSet);
	}
}
