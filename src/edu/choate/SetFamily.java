package edu.choate;

import java.util.AbstractSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dongcarl on 4/22/14.
 */
public class SetFamily extends TreeSet<IntegerSet>
{
	public SetFamily(TreeSet<TreeSet<Integer>> incomingLinkedHashSetOfLinkedHashSetOfInteger)
	{
		self = (SetFamily)incomingLinkedHashSetOfLinkedHashSetOfInteger;
	}


}
