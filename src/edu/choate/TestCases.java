package edu.choate;

import edu.choate.structures.SetFamily;
import edu.choate.structures.SetList;

import java.util.Arrays;
import java.util.*;

/**
 * Created by dongcarl on 5/16/14.
 */
public class TestCases
{
	public static SetList<Set<Integer>> currTest = new SetList<Set<Integer>>(
			Arrays.asList(
					new HashSet<Integer>(Arrays.asList(1, 2, 3)),
					new HashSet<Integer>(Arrays.asList(1, 2, 4)),
					new HashSet<Integer>(Arrays.asList(1, 3, 4)),
					new HashSet<Integer>(Arrays.asList(2, 3, 4)),
					new HashSet<Integer>(Arrays.asList(1, 5, 6)),
					new HashSet<Integer>(Arrays.asList(2, 5, 6)),
					new HashSet<Integer>(Arrays.asList(1, 5, 7)),
					new HashSet<Integer>(Arrays.asList(1, 6, 7)),
					new HashSet<Integer>(Arrays.asList(2, 5, 7)),
					new HashSet<Integer>(Arrays.asList(2, 6, 7)),
					new HashSet<Integer>(Arrays.asList(4, 8, 9)),
					new HashSet<Integer>(Arrays.asList(3, 8, 10)),
					new HashSet<Integer>(Arrays.asList(3, 8, 9)),
					new HashSet<Integer>(Arrays.asList(4, 9, 10)),
					new HashSet<Integer>(Arrays.asList(3, 9, 10)),
					new HashSet<Integer>(Arrays.asList(4, 8, 10))
			)
	);

	public static SetList<Set<Integer>> deltaN3K3Free = new SetList<Set<Integer>>(
		Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1, 2, 7)),
			new HashSet<Integer>(Arrays.asList(1, 3, 7)),
			new HashSet<Integer>(Arrays.asList(2, 3, 7)),
			new HashSet<Integer>(Arrays.asList(4, 5, 7)),
			new HashSet<Integer>(Arrays.asList(4, 6, 7)),
			new HashSet<Integer>(Arrays.asList(5, 6, 7))
		)
	);

	public static SetList<Set<Integer>> deltaN2K3Free = new SetList<Set<Integer>>(
		Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1, 2)),
			new HashSet<Integer>(Arrays.asList(1, 3)),
			new HashSet<Integer>(Arrays.asList(2, 3)),
			new HashSet<Integer>(Arrays.asList(4, 5)),
			new HashSet<Integer>(Arrays.asList(4, 6)),
			new HashSet<Integer>(Arrays.asList(5, 6))
		)
	);

	public static SetList<Set<Integer>> deltaN2K3Free2 = new SetList<Set<Integer>>(
		Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1, 2)),
			new HashSet<Integer>(Arrays.asList(1, 3)),
			new HashSet<Integer>(Arrays.asList(2, 3))
		)
	);

	public static SetList<Set<Integer>> deltaN3K3Free2 = new SetList<Set<Integer>>(
		Arrays.asList(
			new HashSet<Integer>(Arrays.asList(1, 5, 6)),
			new HashSet<Integer>(Arrays.asList(1, 4, 6)),
			new HashSet<Integer>(Arrays.asList(1, 2, 3)),
			new HashSet<Integer>(Arrays.asList(1, 2, 4)),
			new HashSet<Integer>(Arrays.asList(2, 4, 5)),
			new HashSet<Integer>(Arrays.asList(2, 5, 6)),
			new HashSet<Integer>(Arrays.asList(2, 3, 6)),
			new HashSet<Integer>(Arrays.asList(3, 4, 6)),
			new HashSet<Integer>(Arrays.asList(3, 4, 5)),
			new HashSet<Integer>(Arrays.asList(1, 3, 5)),
			new HashSet<Integer>(Arrays.asList(7, 11, 12)),
			new HashSet<Integer>(Arrays.asList(7, 10, 12)),
			new HashSet<Integer>(Arrays.asList(7, 8, 9)),
			new HashSet<Integer>(Arrays.asList(7, 8, 10)),
			new HashSet<Integer>(Arrays.asList(8, 10, 11)),
			new HashSet<Integer>(Arrays.asList(8, 11, 12)),
			new HashSet<Integer>(Arrays.asList(8, 9, 12)),
			new HashSet<Integer>(Arrays.asList(9, 10, 12)),
			new HashSet<Integer>(Arrays.asList(9, 10, 11)),
			new HashSet<Integer>(Arrays.asList(7, 9, 11))
		)
	);
}
