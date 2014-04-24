package edu.choate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * Created by dongcarl on 4/22/14.
 */
public class IntegerSet extends ArrayList<Integer> implements Set<Integer>
{
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
