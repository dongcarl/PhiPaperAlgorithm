package edu.choate;

import org.jgrapht.Graph;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.SimpleGraph;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Yicheng on 5/4/2014.
 */
public class MyBronKerboschCliqueFinder extends BronKerboschCliqueFinder<IntegerSet, Intersection>
{

//    ArrayList<ArrayList> informationGrid = new ArrayList<ArrayList>();
    ArrayList<Graph<IntegerSet, Intersection>> allGraphs = new ArrayList<Graph<IntegerSet, Intersection>>();
	ArrayList<IntegerSet> allIntersectionsRepresentedAsIntegerSets = new ArrayList<IntegerSet>();
	ArrayList<Integer> allMaxNumCliquesForGraph = new ArrayList<Integer>();
	ArrayList<Collection<Set<IntegerSet>>> allBiggestCliques = new ArrayList<Collection<Set<IntegerSet>>>();
	public int maxCliqueNum = 0;

    public MyBronKerboschCliqueFinder(Graph<IntegerSet, Intersection> graph)
    {
        super(graph);

	    // generate all intersections
        for (Intersection i : graph.edgeSet())
        {

            if (!allIntersectionsRepresentedAsIntegerSets.contains(i.toIntegerSet()))
            {
                allIntersectionsRepresentedAsIntegerSets.add(i.toIntegerSet());
            }
        }

	    //generate all graphs for intersections
        for (IntegerSet i : allIntersectionsRepresentedAsIntegerSets)
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

            allGraphs.add(graphForCurrentIntersectionI);
        }

	    for (Graph<IntegerSet, Intersection> i : allGraphs)
	    {
		    BronKerboschCliqueFinder<IntegerSet, Intersection> currCliqueFinder = new BronKerboschCliqueFinder<IntegerSet, Intersection>(i);
		    int currSize = currCliqueFinder.getBiggestMaximalCliques().iterator().next().size();
			allMaxNumCliquesForGraph.add(currSize);
		    allBiggestCliques.add(currCliqueFinder.getBiggestMaximalCliques());
	    }
	    maxCliqueNum = Collections.max(allMaxNumCliquesForGraph);
    }

//    @Override
//    public Collection<Set<V>> getAllMaximalCliques()
//    {
//	    for (Collection<Set<IntegerSet>> i : informationGrid.get(allBiggestCliquesForGraphColumn))
//	    {
//
//	    }
//
//        return super.getAllMaximalCliques();
//    }
//
//    @Override
//    public Collection<Set<V>> getBiggestMaximalCliques()
//    {
//        return super.getBiggestMaximalCliques();
//    }
}
