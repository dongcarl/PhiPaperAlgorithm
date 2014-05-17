package edu.choate;

import edu.choate.structures.IntegerSet;
import edu.choate.structures.SetFamily;

/**
 * Created by dongcarl on 5/16/14.
 */
public class TestCases
{
	public static SetFamily deltaN3K3Free = new SetFamily(
			3,
			new IntegerSet(1, 2, 7),
			new IntegerSet(1, 3, 7),
			new IntegerSet(2, 3, 7),
			new IntegerSet(4, 5, 7),
			new IntegerSet(4, 6, 7),
			new IntegerSet(5, 6, 7)
	);

	public static SetFamily deltaN2K3Free = new SetFamily(
			3,
			new IntegerSet(1, 2),
			new IntegerSet(1, 3),
			new IntegerSet(2, 3),
			new IntegerSet(4, 5),
			new IntegerSet(4, 6),
			new IntegerSet(5, 6)
	);

	public static SetFamily deltaN2K3Free2 = new SetFamily(
			3,
			new IntegerSet(1, 2),
			new IntegerSet(1, 3),
			new IntegerSet(2, 3)
	);

	public static SetFamily deltaN3K3Free2 = new SetFamily(
			3,
			new IntegerSet(1, 5, 6),
			new IntegerSet(1, 4, 6),
			new IntegerSet(1, 2, 3),
			new IntegerSet(1, 2, 4),
			new IntegerSet(2, 4, 5),
			new IntegerSet(2, 5, 6),
			new IntegerSet(2, 3, 6),
			new IntegerSet(3, 4, 6),
			new IntegerSet(3, 4, 5),
			new IntegerSet(1, 3, 5),
			new IntegerSet(7, 11, 12),
			new IntegerSet(7, 10, 12),
			new IntegerSet(7, 8, 9),
			new IntegerSet(7, 8, 10),
			new IntegerSet(8, 10, 11),
			new IntegerSet(8, 11, 12),
			new IntegerSet(8, 9, 12),
			new IntegerSet(9, 10, 12),
			new IntegerSet(9, 10, 11),
			new IntegerSet(7, 9, 11)
	);
}
