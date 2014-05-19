package edu.choate.structures;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by dongcarl on 5/19/14.
 */
public class SetList<E> extends ArrayList<E> implements Set<E>, List<E>
{
	public SetList()
	{
		super();
	}

	public SetList(Collection<? extends E> c)
	{
		super(c);
	}

	public Set<E> toHashSet()
	{
		return new HashSet<E>(this);
	}

	public void removeLast()
	{
		this.remove(this.size()-1);
	}
}
