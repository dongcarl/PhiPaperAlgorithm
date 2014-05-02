package edu.choate;

import java.util.*;

/**
 * Created by dongcarl on 4/22/14.
 * Objects of this family represent a family of sets of a specific size n.
 */
public class SetFamily extends ArrayList<IntegerSet> implements Set<IntegerSet>
{
	public int n; // The size of each set

	public SetFamily(int n, ArrayList<IntegerSet> incomingE)
	{
		this.n = n;
		// need to make sure every set is proper size
		this.addAll(incomingE);
	}

	public SetFamily()
	{
		super();
		this.n=3;
	}

	@Override
	public boolean add(IntegerSet integerSet)
	{
		if (this.contains(integerSet)||(integerSet.size()!=this.n))
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


	public void pop()
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
//	public int[] intersectionVector(IntegerSet integerSet)
//	{
//		//Python code:
////        assert len(myset)==self.p
////        ans=[0]*(len(myset)+1)
////        for aset in self.setList:
////            x=len(aset.intersection(myset))
////            ans[x]+=1
////        return ans[:-1]
//
//	}
	
	public int sizeOfSupport()
	{
		return this.support().size();
	}
	
	public void shift(int num)
	{
		
	}
	
	
}