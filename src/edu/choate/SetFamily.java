package edu.choate;

import java.util.*;

/**
 * Created by dongcarl on 4/22/14.
 */
public class SetFamily extends ArrayList<IntegerSet> implements Set<IntegerSet>
{
	public SetFamily(SetFamily incomingE)
	{
		this.addAll(incomingE);
	}

	public SetFamily()
	{
		super();
	}

	@Override
	public boolean add(IntegerSet integer)
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
	public void add(int index, IntegerSet element)
	{
		if (!super.contains(element))
		{
			super.add(index, element);
		}
	}


	public void pop()
	{
		this.remove(this.size()-1);
	}
}