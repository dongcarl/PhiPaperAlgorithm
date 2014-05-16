package edu.choate.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

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
//        System.out.println("in add:, first boolean returns: " + this.contains(integerSet));
//        System.out.println("in add:, second boolean returns: " + (integerSet.size() != this.n));
//        System.out.println("in add:, size of incoming integerSet is: " + integerSet.size());
//        System.out.println("in add:, n is: " + this.n);
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

