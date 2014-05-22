package edu.choate.utils;

import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class Deltas
{
    public static boolean isDeltaKFree(Set<Set<Integer>> setFamily, int k)
    {
        Collection<Collection<Collection<Integer>>> allBiggest = allBiggestCliquesOfIntersectionsOf(setFamily);
        boolean stop = false;
        for (Collection<Collection<Integer>> c : allBiggest)
        {
            if (c.size() >= k)
            {
                stop = true;
                break;
            }
        }
        return !stop;
    }

    public static Collection<Collection<Collection<Integer>>> allCliquesOf(Set<Set<Integer>> setFamily)
    {
        Collection<Collection<Collection<Integer>>> outgoingCliques = new ArrayList<Collection<Collection<Integer>>>();
        for (SimpleGraph<Collection<Integer>, DefaultEdge> graph : Intersections.allFilledIntersectionGraphMapOf(setFamily).values())
        {
            outgoingCliques.addAll((new BronKerboschCliqueFinder<Collection<Integer>, DefaultEdge>(graph)).getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static Collection<Collection<Collection<Integer>>> allBiggestCliquesOfIntersectionsOf(Set<Set<Integer>> setFamily)
    {
        Collection<Collection<Collection<Integer>>> outgoingCliques = new ArrayList<Collection<Collection<Integer>>>();
        for (SimpleGraph<Collection<Integer>, DefaultEdge> graph : Intersections.allFilledIntersectionGraphMapOf(setFamily).values())
        {
            outgoingCliques.addAll((new BronKerboschCliqueFinder<Collection<Integer>, DefaultEdge>(graph)).getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static int deltaOf(Set<Set<Integer>> setFamily)
    {
        int outgoingLargestDelta = Integer.MIN_VALUE;
        for (Collection<Collection<Integer>> s : allBiggestCliquesOfIntersectionsOf(setFamily))
        {
            if (s.size() > outgoingLargestDelta)
            {
                outgoingLargestDelta = s.size();
            }
        }
        return outgoingLargestDelta;
    }

    public static void main(String[] args)
    {
    }
}
