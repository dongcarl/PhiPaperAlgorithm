package edu.choate.structures;

import edu.choate.structures.IntegerSet;

import java.util.*;

/**
 * Created by dongcarl on 4/22/14.
 * Objects of this family represent a family of sets of a specific size n.
 */
public class SetFamily extends ArrayList<IntegerSet> implements Set<IntegerSet>
{
	public int n; // The size of each set

	public SetFamily(int incomingN, ArrayList<IntegerSet> incomingE)
	{
		super();
		n = incomingN;
 		this.addAll(incomingE);
	}

	public SetFamily(int incomingN)
	{
		super();
		n = incomingN;
	}

    public SetFamily(int incomingN, IntegerSet... a)
    {
	    this.n = (a[0]).size();
        this.addAll(Arrays.asList(a));
    }

	public SetFamily()
	{
		super();
		this.n = 3;
	}

	@Override
	public boolean add(IntegerSet integerSet)
	{
		if (this.contains(integerSet) || (integerSet.size() != this.n))
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


	public IntegerSet pop()
	{
		IntegerSet outgoingIntegerSet = this.get(this.size()-1);
		this.remove(this.size()-1);
		return outgoingIntegerSet;
	}

}

