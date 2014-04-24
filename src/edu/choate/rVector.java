package edu.choate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

/**
 * Created by dongcarl on 4/22/14.
 */
public class rVector extends Vector<Integer>
{
	public rVector()
	{
		super();
	}

	public double distanceTo(rVector incomingRVector)
	{
		long sum = 0;

		if (super.size() == incomingRVector.size())
		{
			for (int i = 0; i < super.size(); i++)
			{
				sum += (super.get(i) - incomingRVector.get(i)) * (super.get(i) - incomingRVector.get(i));
			}
		}

		return Math.sqrt(sum);
	}
}