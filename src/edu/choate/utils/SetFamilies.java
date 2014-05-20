//package edu.choate.utils;
//
//import edu.choate.structures.SetFamily;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by dongcarl on 5/15/14.
// */
//public class SetFamilies
//{
//
//	/**
//	 * Calculates the support of our family of sets
//	 * The support is the set of all elements that are
//	 * included in any one of our smaller sets.
//	 * @return IntegerSet of all elements in any set
//	 * @author mbardoe
//	 * @
//	 */
//	public static Set<Integer> getSupportOf(SetFamily incomingSetFamily)
//	{
//		Set<Integer> retSet = new HashSet<Integer>();
//		for (Set<Integer> currentSet : incomingSetFamily)
//		{
//			for (Integer vertex: currentSet)
//			{
//				retSet.add(vertex);
//			}
//		}
//		return retSet;
//	}
//}
