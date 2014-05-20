package edu.choate.utils;

import edu.choate.TestCases;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class Deltas
{
    public static boolean isDeltaKFree(Set<Set<Integer>> setFamily, int k)
    {
        ArrayList<Set<Set<Integer>>> allBiggest = allBiggestCliquesOfIntersectionsOf(setFamily);
        boolean stop = false;
        for (int i = 0; i < allBiggest.size() && !stop; i++)
        {
            if (allBiggest.get(i).size() >= k)
            {
                stop = true;
            }
        }
        return !stop;
    }

    public static ArrayList<Set<Set<Integer>>> allCliquesOf(Set<Set<Integer>> setFamily)
    {
        ArrayList<Set<Set<Integer>>> outgoingCliques = new ArrayList<Set<Set<Integer>>>();
        for (SimpleGraph<Set<Integer>, DefaultEdge> graph : Intersections.allFilledIntersectionGraphMapOf(setFamily).values())
        {
            outgoingCliques.addAll((new BronKerboschCliqueFinder<Set<Integer>, DefaultEdge>(graph)).getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static ArrayList<Set<Set<Integer>>> allBiggestCliquesOfIntersectionsOf(Set<Set<Integer>> setFamily)
    {
        ArrayList<Set<Set<Integer>>> outgoingCliques = new ArrayList<Set<Set<Integer>>>();
        for (SimpleGraph<Set<Integer>, DefaultEdge> graph : Intersections.allFilledIntersectionGraphMapOf(setFamily).values())
        {
            outgoingCliques.addAll((new BronKerboschCliqueFinder<Set<Integer>, DefaultEdge>(graph)).getAllMaximalCliques());
        }
        return outgoingCliques;
    }

    public static int deltaOf(Set<Set<Integer>> setFamily)
    {
        int outgoingLargestDelta = Integer.MIN_VALUE;
        for (Set<Set<Integer>> s : allBiggestCliquesOfIntersectionsOf(setFamily))
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
        Set<Set<Integer>> testCase = TestCases.deltaN3K3Free;
        System.out.println(testCase);
        System.out.println(allCliquesOf(testCase));
        System.out.println(isDeltaKFree(testCase, 3));
    }
}
