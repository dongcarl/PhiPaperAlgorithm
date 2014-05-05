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
	static SimpleGraph<IntegerSet, Intersection> graph;

	public DeltaFreeSystem(int incomingN, int incomingK, SetFamily incomingE)
    {
        super(incomingN, incomingE);

        System.out.println("Going to construct a DeltaFreeSystem with:");
        System.out.println('\t' + "n = " + incomingN);
        System.out.println('\t' + "k = " + incomingK);
        System.out.println('\t' + "E = " + incomingE);

        k = incomingK;

        System.out.println("Just set k to " + incomingK);

        graph = graphFromSetFamily(incomingE);

        System.out.println("Just generated graph " + graph + " using method graphFromSetFamily with parameter " + incomingE);

        System.out.println("Going to check if E contains delta");
        if (this.containsDelta())
        {
//            System.out.println("E does contain delta, going to throw exception");
//            throw new InvalidParameterException();
            System.out.println("IT CONTAINS DELTA!!");
        }
        else
        {
            System.out.println("IT DOESN'T CONTAIN DELTA!!");
        }
	}

    public boolean containsDelta()
    {
        return graphContainsDelta(graph);
    }

    public <V, E> boolean graphContainsDelta(SimpleGraph<V, E> incomingSimpleGraph)
    {
        System.out.println("At the very first line of graphContainsDelta with parameter: " + incomingSimpleGraph);
        System.out.println("incomingSimpleGraph has MaximalCliques: ");

        Collection<Set<V>> maximalCliques = (new BronKerboschCliqueFinder<V, E>(incomingSimpleGraph)).getBiggestMaximalCliques();
        for (Set<V> i : maximalCliques)
        {
            System.out.println("Set<V> " + i + " of " + maximalCliques.size() + " elements in maximalCliques has " + i.size() + " elements");
        }
        return (new BronKerboschCliqueFinder<V, E>(incomingSimpleGraph)).getBiggestMaximalCliques().iterator().next().size() >= k;
    }

    public Set<Intersection> allIntersections()
    {
        return graph.edgeSet();
    }

    public Set<SimpleGraph<IntegerSet, DefaultEdge>> allGraphsOfIntersections(Set<Intersection> intersectionSet)
    {
        Set<SimpleGraph<IntegerSet, DefaultEdge>> outgoingGraphs = new HashSet<SimpleGraph<IntegerSet, DefaultEdge>>();

        for (Intersection intersection : intersectionSet)
        {

        }
    }

    public SimpleGraph<IntegerSet, Intersection> graphFromSetFamily(SetFamily incomingSetFamily)
    {
        System.out.println("At the very first line of graphFromSetFamily, called with SetFamily: " + incomingSetFamily);
        SimpleGraph<IntegerSet, Intersection> outgoingGraph = new SimpleGraph<IntegerSet, Intersection>(Intersection.class);
        System.out.println("A SimpleGraph with Edge of IntegerSet and Vertex of IntegerSet initialized: " + outgoingGraph);

        System.out.println("Going to add all IntegerSets in incomingSetFamily to outgoingGraph as Vertices");
        for (IntegerSet i : incomingSetFamily)
        {
                outgoingGraph.addVertex(i);
                System.out.println("Just added Vertex: " + i);
        }
        System.out.println("Just added all IntegerSets in incomingSetFamily to outgoingGraph as Vertices");

        System.out.println("Going to add all intersections of i and v of incomingSetFamily to outgoingGraph as Edges");
        for (int i = 0; i < incomingSetFamily.size(); i++)
        {
            for (int v = i+1; v < incomingSetFamily.size(); v++)
            {
                System.out.println("Iterating through incomingSetFamily with i = " + i + " and v = " + v);
                IntegerSet alphaVertex = incomingSetFamily.get(i);
                IntegerSet betaVertex = incomingSetFamily.get(v);
                Intersection intersection = new Intersection(alphaVertex, betaVertex);
                System.out.println("Just initialized:");
                System.out.println('\t' + "alphaVertex = " + alphaVertex);
                System.out.println('\t' + "betaVertex = " + betaVertex);
                System.out.println('\t' + "intersection = " + intersection);
                outgoingGraph.addEdge(alphaVertex, betaVertex, intersection);
                System.out.println("Just added an Edge: " + intersection + " with alphaVertex: " + alphaVertex + " and betaVertex: " + betaVertex);
            }
        }

        System.out.println("Going to return: " +outgoingGraph + " with " + outgoingGraph.edgeSet().size() + " edges and " + outgoingGraph.vertexSet().size() + " vertices");
        return outgoingGraph;
    }

	public static void main(String[] args)
    {
        SetFamily deltaFree3System = new SetFamily();
        SetFamily hasDelta3System = new SetFamily();

        deltaFree3System.n = 3;
        deltaFree3System.add(new IntegerSet(Arrays.asList(1, 2, 7)));
        deltaFree3System.add(new IntegerSet(Arrays.asList(1, 3, 7)));
        deltaFree3System.add(new IntegerSet(Arrays.asList(2, 3, 7)));
        deltaFree3System.add(new IntegerSet(Arrays.asList(4, 3, 7)));
        deltaFree3System.add(new IntegerSet(Arrays.asList(4, 6, 7)));
        deltaFree3System.add(new IntegerSet(Arrays.asList(5, 6, 7)));

        hasDelta3System.n = 3;
        hasDelta3System.add(new IntegerSet(Arrays.asList(1, 2, 3)));
        hasDelta3System.add(new IntegerSet(Arrays.asList(4, 5, 6)));
        hasDelta3System.add(new IntegerSet(Arrays.asList(7, 8, 9)));


        DeltaFreeSystem deltaFree3SystemReal = new DeltaFreeSystem(3, 3, deltaFree3System);
        DeltaFreeSystem hasDelta3SystemReal = new DeltaFreeSystem(3, 3, hasDelta3System);

        System.out.println(deltaFree3SystemReal);
        System.out.println(deltaFree3SystemReal.containsDelta());

        System.out.println(hasDelta3SystemReal);
        System.out.println(hasDelta3SystemReal.containsDelta());
    }

}

class intersectionAndGraphPair
{
    Intersection intersection;
    Graph<IntegerSet, Intersection> graph = ;
}