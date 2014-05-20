package edu.choate.utils;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Sets;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dongcarl on 5/13/14.
 */
public class Intersections
{
//    public static Set<Set<Integer>> allIntersectionsOf(Set<Set<Integer>> setFamily)
//    {
//        Set<Set<Integer>> outgoingIntersections = new HashSet<Set<Integer>>(/*setFamily.n*/);
//
//        ArrayList<Set<Integer>> arrayList = new ArrayList<Set<Integer>>(setFamily);
//
//        for (int i = 0; i < arrayList.size(); i++)
//        {
//            for (int v = i + 1; v < arrayList.size(); v++)
//            {
//                outgoingIntersections.add(Sets.intersection(arrayList.get(i), arrayList.get(v)));
//            }
//        }
//
//        return outgoingIntersections;
//    }
//
//	public static Set<IntersectionGraph> allEmptyIntersectionGraphsOf(Set<Set<Integer>> setFamily)
//	{
//		Set<IntersectionGraph> outgoingIntersectionGraphs = new HashSet<IntersectionGraph>();
//
//        for (Set<Integer> currIntersection : allIntersectionsOf(setFamily))
//        {
//	        outgoingIntersectionGraphs.add(new IntersectionGraph(currIntersection));
//        }
//
//        return outgoingIntersectionGraphs;
//	}
//
//    public static Set<IntersectionGraph> allFilledIntersectionGraphsOf(Set<Set<Integer>> setFamily)
//    {
//	    Set<IntersectionGraph> outgoingFilledIntersectionGraphs = new HashSet<IntersectionGraph>(allEmptyIntersectionGraphsOf(setFamily));
//
//	    ArrayList<Set<Integer>> arrayList = new ArrayList<Set<Integer>>(setFamily);
//
//	    for (int i = 0; i < arrayList.size(); i++)
//        {
//            for (int j = i + 1; j < arrayList.size(); j++)
//            {
//                for (IntersectionGraph graph : outgoingFilledIntersectionGraphs)
//                {
//                    graph.addVerticesAndGenerateCorrespondingEdge(arrayList.get(i), arrayList.get(j));
//                }
//            }
//        }
//
//        return outgoingFilledIntersectionGraphs;
//    }

    public static BiMap<Set<Integer>, SimpleGraph<Set<Integer>, DefaultEdge>> allFilledIntersectionGraphMapOf(Set<Set<Integer>> setFamily)
    {
        ArrayList<Set<Integer>> setArrayList = new ArrayList<Set<Integer>>(setFamily);
        BiMap<Set<Integer>, SimpleGraph<Set<Integer>, DefaultEdge>> outgoingIntersectionMap = HashBiMap.create();

        for (int i = 0; i < setArrayList.size(); i++)
        {
            for (int j = i + 1; j < setArrayList.size(); j++)
            {
                Set<Integer> first = setArrayList.get(i);
                Set<Integer> second = setArrayList.get(j);
                Set<Integer> currentIntersection = Sets.intersection(first, second);
                SimpleGraph<Set<Integer>, DefaultEdge> existingGraph;


                if (!outgoingIntersectionMap.containsKey(currentIntersection))
                {
                    outgoingIntersectionMap.put(currentIntersection, new SimpleGraph<Set<Integer>, DefaultEdge>(DefaultEdge.class));
                }

                existingGraph = outgoingIntersectionMap.get(currentIntersection);
                existingGraph.addVertex(first);
                existingGraph.addVertex(second);
                existingGraph.addEdge(first, second);
            }
        }
        return outgoingIntersectionMap;
    }

    public static void main(String[] args)
    {
//        System.out.println("Testing: public static ArrayList<Set<Integer>> allIntersectionsOf(Set<Set<Integer>> setFamily)");
//        System.out.println("↳ outputted: " + allIntersectionsOf(TestCases.deltaN2K3Free2));
//        System.out.println("↳ expected: " + Sets.newHashSet(
//                Sets.newHashSet(3),
//                Sets.newHashSet(1),
//                Sets.newHashSet(2)
//        ));
//        System.out.println("↳ .equals says: " + allIntersectionsOf(TestCases.deltaN2K3Free2).equals(Sets.newHashSet(
//                Sets.newHashSet(3),
//                Sets.newHashSet(1),
//                Sets.newHashSet(2)
//        )));
    }


}
