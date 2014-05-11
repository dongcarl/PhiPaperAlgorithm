/**
 * 
 */
package edu.choate;

import org.jgrapht.*;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import sun.java2d.pipe.SpanShapeRenderer;

import java.lang.reflect.ParameterizedType;
import java.security.InvalidParameterException;
import java.util.*;

/**
 * This class simulates a family of sets that is delta(n) free for some 
 * given value of n.
 * @author mbardoe
 *
 */
public class DeltaFreeSystem extends SetFamily
{

    private int k;
	public IntersectionGraphFamilyWrapper intersectionGraphs = new IntersectionGraphFamilyWrapper();

	public DeltaFreeSystem(int incomingN, int incomingK, SetFamily incomingE)
    {
        super(incomingN, incomingE);

        System.out.println("Going to construct a DeltaFreeSystem with:");
        System.out.println('\t' + "n = " + incomingN);
        System.out.println('\t' + "k = " + incomingK);
        System.out.println('\t' + "E = " + incomingE);

        k = incomingK;

	    for (int i = 0; i < incomingE.size(); i++)
	    {
		    for (int v = i + 1; v < incomingE.size(); v++)
		    {
			    intersectionGraphs.attemptToAddVertices(incomingE.get(i), incomingE.get(v));
//			    boolean stop = false;
//			    IntegerSet alphaVertex = incomingE.get(i);
//			    IntegerSet betaVertex = incomingE.get(v);
//			    IntegerSet intersection = alphaVertex.intersection(betaVertex);
//			    for (int j = 0; j < intersectionGraphs.size() && !stop; j++)
//			    {
//				    IntersectionGraphWrapper currIntersectionGraph = intersectionGraphs.get(j)
//				    if (currIntersectionGraph.intersection.equals(intersection))
//				    {
//					    currIntersectionGraph.addVerticesAndGenerateCorrespondingEdge(alphaVertex, betaVertex);
//					    stop = true;
//				    }
//				    else if (j == intersectionGraphs.size() - 1)
//				    {
//					    IntersectionGraphWrapper currNewIntersectionGraph = new IntersectionGraphWrapper(Intersection.class);
//					    intersectionGraphs.add(currNewIntersectionGraph);
//					    currNewIntersectionGraph.addVerticesAndGenerateCorrespondingEdge(alphaVertex, betaVertex);
//					    stop = true;
//				    }
//			    }
		    }
	    }

//        System.out.println("Just set k to " + incomingK);
//
//        graph = graphFromSetFamily(incomingE);
//
//        System.out.println("Just generated graph " + graph + " using method graphFromSetFamily with parameter " + incomingE);
//
//        System.out.println("Going to check if E contains delta");
//        if (this.containsDelta())
//        {
//            System.out.println("IT CONTAINS DELTA!!");
//        }
//        else
//        {
//            System.out.println("IT DOESN'T CONTAIN DELTA!!");
//        }
	}

    public boolean containsDelta()
    {
	    System.out.println("Going to check if: " + this + " containsDelta: " + k + "...");
	    System.out.println("The Largest of All Biggest Maximal Clique Numbers is: " + intersectionGraphs.getLargestOfAllBiggestMaximalCliqueNumbers() + " and k is: " + k);
        return intersectionGraphs.getLargestOfAllBiggestMaximalCliqueNumbers() >= k;
    }

//    public boolean graphContainsDelta(SimpleGraph<IntegerSet, Intersection> incomingSimpleGraph)
//    {
//        System.out.println("At the very first line of graphContainsDelta with parameter: " + incomingSimpleGraph);
//        System.out.println("incomingSimpleGraph has MaximalCliques: ");
//
//	    MyBronKerboschCliqueFinder cliqueFinder = new MyBronKerboschCliqueFinder(incomingSimpleGraph);
//	    return cliqueFinder.maxCliqueNum >= k;
////        Collection<Set<V>> maximalCliques = (new BronKerboschCliqueFinder<V, E>(incomingSimpleGraph)).getBiggestMaximalCliques();
////        for (Set<V> i : maximalCliques)
////        {
////            System.out.println("Set<V> " + i + " of " + maximalCliques.size() + " elements in maximalCliques has " + i.size() + " elements");
////        }
////        return (new BronKerboschCliqueFinder<V, E>(incomingSimpleGraph)).getBiggestMaximalCliques().iterator().next().size() >= k;
//    }
//
//    public Set<Intersection> allIntersections()
//    {
//        return graph.edgeSet();
//    }
//
////    public Set<SimpleGraph<IntegerSet, DefaultEdge>> allGraphsOfIntersections(Set<Intersection> intersectionSet)
////    {
////        Set<SimpleGraph<IntegerSet, DefaultEdge>> outgoingGraphs = new HashSet<SimpleGraph<IntegerSet, DefaultEdge>>();
////
////        for (Intersection intersection : intersectionSet)
////        {
////
////        }
////    }
//
//    public SimpleGraph<IntegerSet, Intersection> graphFromSetFamily(SetFamily incomingSetFamily)
//    {
//        System.out.println("At the very first line of graphFromSetFamily, called with SetFamily: " + incomingSetFamily);
//        SimpleGraph<IntegerSet, Intersection> outgoingGraph = new SimpleGraph<IntegerSet, Intersection>(Intersection.class);
//        System.out.println("A SimpleGraph with Edge of IntegerSet and Vertex of IntegerSet initialized: " + outgoingGraph);
//
//        System.out.println("Going to add all IntegerSets in incomingSetFamily to outgoingGraph as Vertices");
//        for (IntegerSet i : incomingSetFamily)
//        {
//                outgoingGraph.addVertex(i);
//                System.out.println("Just added Vertex: " + i);
//        }
//        System.out.println("Just added all IntegerSets in incomingSetFamily to outgoingGraph as Vertices");
//
//        System.out.println("Going to add all intersections of i and v of incomingSetFamily to outgoingGraph as Edges");
//        for (int i = 0; i < incomingSetFamily.size(); i++)
//        {
//            for (int v = i+1; v < incomingSetFamily.size(); v++)
//            {
//                System.out.println("Iterating through incomingSetFamily with i = " + i + " and v = " + v);
//                IntegerSet alphaVertex = incomingSetFamily.get(i);
//                IntegerSet betaVertex = incomingSetFamily.get(v);
//                Intersection intersection = new Intersection(alphaVertex, betaVertex);
//                System.out.println("Just initialized:");
//                System.out.println('\t' + "alphaVertex = " + alphaVertex);
//                System.out.println('\t' + "betaVertex = " + betaVertex);
//                System.out.println('\t' + "intersection = " + intersection);
//                outgoingGraph.addEdge(alphaVertex, betaVertex, intersection);
//                System.out.println("Just added an Edge: " + intersection + " with alphaVertex: " + alphaVertex + " and betaVertex: " + betaVertex);
//            }
//        }
//
//        System.out.println("Going to return: " +outgoingGraph + " with " + outgoingGraph.edgeSet().size() + " edges and " + outgoingGraph.vertexSet().size() + " vertices");
//        return outgoingGraph;
//    }

	public static void main(String[] args)
    {
        SetFamily deltaFree3System = new SetFamily();
        SetFamily hasDelta3System = new SetFamily();

        deltaFree3System.n = 3;
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,2,9)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,7)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,7,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,4,8)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,5,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,7,8)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,9,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,4,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,6,9)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,9,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,5,8)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,8,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,6,9)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,7,8)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,9,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,8,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(7,10,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,7)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,6,9)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,9,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,5,6)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,6,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,8,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,4,7)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,5,9)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,7,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,10,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,7,10)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,10,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,6,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,8,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,7,8)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,8,11)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(9,11,12)));
	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,5,11)));
//        deltaFree3System.add(new IntegerSet(Arrays.asList(5, 6, 7)));


        hasDelta3System.n = 3;
        hasDelta3System.add(new IntegerSet(Arrays.asList(1, 2, 3)));
        hasDelta3System.add(new IntegerSet(Arrays.asList(4, 5, 6)));
        hasDelta3System.add(new IntegerSet(Arrays.asList(7, 8, 9)));


        DeltaFreeSystem deltaFree3SystemReal = new DeltaFreeSystem(3, 4, deltaFree3System);
	    System.out.println("Here are the intersection graphs for this delta system:");
	    for (IntersectionGraphWrapper g : deltaFree3SystemReal.intersectionGraphs.wrappedIntersectionGraphFamily)
	    {
		    System.out.println(g.wrappedGraph);
	    }

        DeltaFreeSystem hasDelta3SystemReal = new DeltaFreeSystem(3, 3, hasDelta3System);

        System.out.println(deltaFree3SystemReal);
        System.out.println(deltaFree3SystemReal.containsDelta());

        System.out.println(hasDelta3SystemReal);
        System.out.println(hasDelta3SystemReal.containsDelta());
    }

}