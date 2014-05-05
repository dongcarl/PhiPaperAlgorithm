package edu.choate;

import org.jgrapht.Graph;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yicheng on 5/4/2014.
 */
public class MyBronKerboschCliqueFinder extends BronKerboschCliqueFinder<IntegerSet, Intersection>
{

    ArrayList<ArrayList> informationGrid = new ArrayList<ArrayList>();
    Set<Graph<IntegerSet, Intersection>> graphSet = new HashSet<Graph<IntegerSet, Intersection>>();

    enum columnDescriptors
    {
        int intersectionIntegerSetColumn = 0;
        int
    }

    public MyBronKerboschCliqueFinder(Graph<IntegerSet, Intersection> graph)
    {
        super(graph);

        SetFamily allIntersections = new SetFamily();
        for (Intersection i : graph.edgeSet())
        {

            if (!allIntersections.contains(i.toIntegerSet()))
            {
                allIntersections.add(i.toIntegerSet());
            }
        }

        for (IntegerSet i : allIntersections)
        {
            Graph<IntegerSet, Intersection> graphForCurrentIntersectionI = new SimpleGraph<IntegerSet, Intersection>(Intersection.class);

            for (Intersection ii : graph.edgeSet())
            {
                if (ii.toIntegerSet() == i)
                {
                    graphForCurrentIntersectionI.addVertex(ii.alphaVertex);
                    graphForCurrentIntersectionI.addVertex(ii.betaVertex);
                    graphForCurrentIntersectionI.addEdge(ii.alphaVertex, ii.betaVertex);
                }
            }

            graphSet.add(graphForCurrentIntersectionI);
        }


    }

//    @Override
//    public Collection<Set<V>> getAllMaximalCliques()
//    {
//        return super.getAllMaximalCliques();
//    }
//
//    @Override
//    public Collection<Set<V>> getBiggestMaximalCliques()
//    {
//        return super.getBiggestMaximalCliques();
//    }
}
