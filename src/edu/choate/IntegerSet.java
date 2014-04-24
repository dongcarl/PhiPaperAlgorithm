package edu.choate;

import java.util.*;

/**
 * Created by dongcarl on 4/22/14.
 */
public class IntegerSet extends ArrayList<Integer> implements Set<Integer>
{
	public IntegerSet(List<Integer> integers)
	{
		for(Integer i : integers)
			{this.add(i);}
	}

	public IntegerSet()
	{
		super();
	}
	
	public IntegerSet(int[] nums)
	{
		for (Integer i : nums)
		{
			this.add(i);
		}
	}
	

	@Override
	public boolean add(Integer integer)
	{
		if (this.contains(integer))
		{
			return false;
		}
		else
		{
			super.add(integer);
			return true;
		}
	}

	@Override
	public void add(int index, Integer element)
	{
		if (!super.contains(element))
		{
			super.add(index, element);
		}
	}
	
	public IntegerSet intersection(IntegerSet right)
	{
		IntegerSet retSet= new IntegerSet(this);
		retSet.retainAll(right);
		return retSet;
		
	}
	
	public IntegerSet union(IntegerSet right)
	{
		IntegerSet retSet= new IntegerSet(this);
		retSet.addAll(right);
		return retSet;
		
	}
	public IntegerSet difference(IntegerSet right)
	{
		IntegerSet retSet= new IntegerSet(this);
		retSet.removeAll(right);
		return retSet;
	}
	
	public static void main(String[] args)
	{
		System.out.println("A set a with 1,2,3");
		IntegerSet a = new IntegerSet(new int[]{1,2,3});
		System.out.println(a);
		System.out.println("A set b with 1,2,4,4");
		IntegerSet b = new IntegerSet(new int[]{1,2,4,4});
		System.out.println(b);
		System.out.println("The intersection of a and b");
		IntegerSet c = a.intersection(b);
		System.out.println(c);
		
		
	}
}
