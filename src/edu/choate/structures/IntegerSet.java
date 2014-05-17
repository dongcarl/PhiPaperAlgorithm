package edu.choate.structures;

import java.util.*;

/** A
 *
 * @author Carl Dong, Homo Sapien
 * @author Matthew Barode, PhD.
 */
public class IntegerSet extends ArrayList<Integer> implements Set<Integer>
{
	public IntegerSet(List<Integer> integers)
	{
		for(Integer i : integers)
		{
//			System.out.println("Attempting to add: " + i);
			this.add(i);
		}
//		System.out.println("At the end of adding... the IntegerSet looks like: " + this);
	}

    public IntegerSet(Integer... a)
    {
        this.addAll(Arrays.asList(a));
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
        boolean outgoingDidAdd = false;
		if (!this.contains(integer))
		{
			super.add(integer);
			outgoingDidAdd = true;
		}
        return outgoingDidAdd;
	}

	@Override
	public void add(int index, Integer element)
	{
		if (!this.contains(element))
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

    @Override
    public boolean equals(Object o)
    {
        return (new HashSet<Integer>(this)).equals((new HashSet<Integer>((IntegerSet)o)));
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
