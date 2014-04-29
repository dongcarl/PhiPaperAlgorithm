package edu.choate;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dongcarl on 4/29/14.
 */
public class Intersection extends IntegerSet
{
	static ArrayList<Integer> intersection;
	public HashSet<IntegerSet> sets;

	public Intersection(IntegerSet intSet1, IntegerSet intSet2)
	{
		super();
		intersection = intSet1.intersection(intSet2);

		sets = new HashSet<IntegerSet>();
		sets.add(intSet1);
		sets.add(intSet2);
	}
}