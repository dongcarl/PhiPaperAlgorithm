package edu.choate;

import java.util.Objects;

/**
 * Created by dongcarl on 5/8/14.
 */
public class idealRVector extends rVector
{
	public idealRVector(int length)
	{
		super();
		for (int i = 0; i < length; i++)
		{
			this.add(Integer.MAX_VALUE);
		}
//		this.add(10);
//		this.add(6);
//		this.add(3);
	}

	public boolean checkConsistency()
	{
		boolean outgoingAllSame = true;
		Object lastChecked = null;
		for (Integer i : this)
		{
			if (lastChecked == null)
			{
				lastChecked = i;
			}
			else
			{
				if (!i.equals(lastChecked))
				{
					outgoingAllSame = false;
				}
			}
		}
		return outgoingAllSame;
	}
}
