/**
 * 
 */
package edu.choate;

import org.jgrapht.*;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * This class simulates a family of sets that is delta(n) free for some 
 * given value of n.
 * @author mbardoe
 *
 */
public class DeltaFreeSystem extends SetFamily
{
    private int k;
	static SimpleGraph<IntegerSetVertex, IntersectionEdge> graph;

	public DeltaFreeSystem(int incomingN, int incomingK, SetFamily incomingE)
    {
        super(incomingN, incomingE);

        k = incomingK;
        graph = graphFromSetFamily(incomingE);

        if (setFamilyContainsDelta(incomingE))
        {
            throw new InvalidParameterException();
        }
	}

    public boolean containsDelta()
    {
        return graphContainsDelta(graph);
    }

	public boolean setFamilyContainsDelta(SetFamily incomingSetFamily)
	{
        return graphContainsDelta(graphFromSetFamily(incomingSetFamily));
	}

    public <V, E> boolean graphContainsDelta(SimpleGraph<V, E> incomingSimpleGraph)
    {
        return (new BronKerboschCliqueFinder<V, E>(incomingSimpleGraph)).getBiggestMaximalCliques().iterator().next().size() >= k;
    }

    public SimpleGraph<IntegerSetVertex, IntersectionEdge> graphFromSetFamily(SetFamily incomingSetFamily)
    {
        SimpleGraph<IntegerSetVertex, IntersectionEdge> outgoingGraph = new SimpleGraph<IntegerSetVertex, IntersectionEdge>(IntersectionEdge.class);

//		intersectionGrid intersectionGrid = new intersectionGrid();

        for (int i = 0; i < incomingSetFamily.size(); i++)
        {
            for (int v = i+1; v < incomingSetFamily.size(); v++)
            {
                IntersectionEdge currEdge = new IntersectionEdge(new Intersection(incomingSetFamily.get(i), incomingSetFamily.get(v)));
                outgoingGraph.addVertex(currEdge.alphaVertex);
                outgoingGraph.addVertex(currEdge.betaVertex);
                outgoingGraph.addEdge(currEdge.alphaVertex, currEdge.betaVertex, currEdge);
            }
        }

        return outgoingGraph;
    }

	public static void main(String[] args)
    {
        SetFamily family = new SetFamily();

        family.n = 3;
        family.add(new IntegerSet(Arrays.asList(1, 2, 7)));
        family.add(new IntegerSet(Arrays.asList(1, 3, 7)));
        family.add(new IntegerSet(Arrays.asList(2, 3, 7)));
        family.add(new IntegerSet(Arrays.asList(4, 5, 7)));
        family.add(new IntegerSet(Arrays.asList(4, 6, 7)));
        family.add(new IntegerSet(Arrays.asList(5, 6, 7)));

        DeltaFreeSystem deltaFreeSystem = new DeltaFreeSystem(3, 3, family);

        System.out.println(deltaFreeSystem);
        System.out.println(deltaFreeSystem.containsDelta());
    }

}
