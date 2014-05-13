package edu.choate;

import java.util.*;

/**
 * Created by dongcarl on 4/22/14.
 * Objects of this family represent a family of sets of a specific size n.
 */
public class SetFamily extends ArrayList<IntegerSet> implements Set<IntegerSet>
{
	public Integer n; // The size of each set

	public SetFamily(int n, ArrayList<IntegerSet> incomingE)
	{
		super();
		this.n = n;
 		this.addAll(incomingE);
	}

	public SetFamily(int incomingN)
	{
		super();
		n = incomingN;
	}

	public SetFamily()
	{
		super();
	}

	@Override
	public boolean add(IntegerSet integerSet)
	{
		if (this.contains(integerSet)||(integerSet.size()!=this.n)||(n == null))
		{
			return false;
		}
		else
		{
			super.add(integerSet);
			return true;
		}
	}

	@Override
	public void add(int index, IntegerSet element)
	{
		this.add(element);
	}


	public void removeLast()
	{
		// I don't get what this is doing. DB
		this.remove(this.size()-1);
	}
	/**
	 * Calculates the support of our family of sets
	 * The support is the set of all elements that are
	 * included in any one of our smaller sets.
	 * @return IntegerSet of all elements in any set
	 * @author mbardoe
	 * @
	 */
	public IntegerSet support()
	{
		IntegerSet retSet=new IntegerSet();
		for (IntegerSet currentSet: this)
		{
			for (Integer vertex: currentSet)
			{
				retSet.add(vertex);
			}
			
		}
		return retSet;
	}

	public IntersectionGraphFamilyWrapper toIntersectionGraphs()
	{
		IntersectionGraphFamilyWrapper outgoingIntersectionGraphs = new IntersectionGraphFamilyWrapper();

		for (int i = 0; i < this.size(); i++)
		{
			for (int v = i + 1; v < this.size(); v++)
			{
				outgoingIntersectionGraphs.addVertices(this.get(i), this.get(v));
			}
		}

		return outgoingIntersectionGraphs;
	}

}