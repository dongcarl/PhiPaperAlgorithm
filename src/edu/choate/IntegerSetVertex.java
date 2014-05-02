package edu.choate;

/**
 * Created by dongcarl on 4/29/14.
 */
public class IntegerSetVertex extends Object
{
	static IntegerSet wrappedIntegerSet;

	public IntegerSetVertex(IntegerSet incomingIntegerSet)
	{
		super();
		wrappedIntegerSet = incomingIntegerSet;
	}
}
