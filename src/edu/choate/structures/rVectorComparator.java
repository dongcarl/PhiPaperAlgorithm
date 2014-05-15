package edu.choate.structures;

import edu.choate.idealRVector;
import edu.choate.structures.rVector;

import java.util.Comparator;

/**
 * Created by dongcarl on 4/22/14.
 */
public class rVectorComparator implements Comparator<rVector>
{
	public static edu.choate.idealRVector idealRVector;
	
	public rVectorComparator(idealRVector incomingIdealRVector)
	{
		super();
		idealRVector = incomingIdealRVector;
	}
	
	@Override
	public int compare(rVector o1, rVector o2)
	{
		return Double.compare(o1.distanceTo(idealRVector), o2.distanceTo(idealRVector));
	}
}
