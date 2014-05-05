package edu.choate;

import java.util.ArrayList;

/**
 * Created by dongcarl on 4/29/14.
 */
public class Intersection extends IntegerSet
{
    public IntegerSet alphaVertex;
    public IntegerSet betaVertex;


    public Intersection(IntegerSet incomingAlphaVertex, IntegerSet incomingBetaVertex)
    {
        super();
        alphaVertex = incomingAlphaVertex;
        betaVertex = incomingBetaVertex;
        this.addAll(alphaVertex.intersection(betaVertex));
    }

    public IntegerSet toIntegerSet()
    {
        ArrayList<Integer> listFromIntersection = new ArrayList<Integer>();
        listFromIntersection.addAll(this);
        return new IntegerSet(listFromIntersection);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass() == Intersection.class)
        {
            Intersection edge = (Intersection)obj;
            return ((this.alphaVertex == edge.alphaVertex && this.betaVertex == edge.betaVertex) || (this.alphaVertex == edge.betaVertex && this.betaVertex == edge.alphaVertex));
        }
        return false;
    }
}