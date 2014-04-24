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
}
