package edu.choate.structures;

import com.google.common.math.IntMath;
import edu.choate.structures.rVector;
import edu.choate.utils.IntArrays;

import java.util.Comparator;

/**
 * Created by dongcarl on 4/22/14.
 */
public class rVectorComparator implements Comparator<int[]>
{
	public static int[] idealRVector;
	
	public rVectorComparator(int[] incomingIdealRVector)
	{
		super();
		idealRVector = incomingIdealRVector;
	}
	
	@Override
	public int compare(int[] o1, int[] o2)
	{
		return Double.compare(IntArrays.euclideanDistance(o1, idealRVector), IntArrays.euclideanDistance(o2, idealRVector));
	}
}
