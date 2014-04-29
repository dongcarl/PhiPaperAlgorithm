/**
 * 
 */
package edu.choate;

import org.jgrapht.*;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * This class simulates a family of sets that is delta(n) free for some 
 * given value of n.
 * @author mbardoe
 *
 */
public class DeltaFreeSystem extends SetFamily {

	static SimpleGraph<IntegerSetVertex, IntersectionEdge> graph;
	/**
	 * @param n is the size of each set in the family
	 * @param k is the size the deltasystem that is not allowed.
	 * @param incomingE
	 */
	public DeltaFreeSystem(int n, int k, SetFamily incomingE) {
		super(n, incomingE);
		// TODO Auto-generated constructor stub
	}

	public static boolean checkContainsDelta(int n, int k, SetFamily incomingE)
	{
		graph = new SimpleGraph<IntegerSetVertex, IntersectionEdge>(IntersectionEdge.class);

//		intersectionGrid intersectionGrid = new intersectionGrid();

		for (int i = 0; i < incomingE.size(); i++)
		{
			for (int v = i+1; v < incomingE.size(); v++)
			{
				IntersectionEdge currEdge = new IntersectionEdge(new Intersection(incomingE.get(i), incomingE.get(v)));
				IntegerSetVertex[] aVertex = (IntegerSetVertex[])currEdge.vertices.toArray();
				graph.addEdge(aVertex[0], aVertex[1], currEdge);
			}
		}

		BronKerboschCliqueFinder<IntegerSetVertex, IntersectionEdge> cliqueFinder = new BronKerboschCliqueFinder<IntegerSetVertex, IntersectionEdge>(graph);

		return cliqueFinder.getBiggestMaximalCliques().iterator().next().size() >= k;

	}



	/**
	 * 
	 */
	public DeltaFreeSystem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
