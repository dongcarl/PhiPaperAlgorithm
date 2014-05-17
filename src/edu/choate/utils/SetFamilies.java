package edu.choate.utils;

import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

/**
 * Created by dongcarl on 5/15/14.
 */
public class SetFamilies
{

	/**
	 * Calculates the support of our family of sets
	 * The support is the set of all elements that are
	 * included in any one of our smaller sets.
	 * @return IntegerSet of all elements in any set
	 * @author mbardoe
	 * @
	 */
	public static IntegerSet getSupportOf(SetFamily incomingSetFamily)
	{
		IntegerSet retSet = new IntegerSet();
		for (IntegerSet currentSet : incomingSetFamily)
		{
			for (Integer vertex: currentSet)
			{
				retSet.add(vertex);
			}
		}
		return retSet;
	}
}
