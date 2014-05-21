package edu.choate;


import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by dongcarl on 5/16/14.
 */
public class TestCases
{
    public static ArrayList<Set<Integer>> currTest = new ArrayList<Set<Integer>>(
            Arrays.asList(
                    Sets.newHashSet(1, 2, 3),
                    Sets.newHashSet(1, 2, 4),
                    Sets.newHashSet(1, 3, 4),
                    Sets.newHashSet(2, 3, 4),
                    Sets.newHashSet(1, 5, 6),
                    Sets.newHashSet(2, 5, 6),
                    Sets.newHashSet(1, 5, 7),
                    Sets.newHashSet(1, 6, 7),
                    Sets.newHashSet(2, 5, 7),
                    Sets.newHashSet(2, 6, 7),
                    Sets.newHashSet(4, 8, 9),
                    Sets.newHashSet(3, 8, 10),
                    Sets.newHashSet(3, 8, 9),
                    Sets.newHashSet(4, 9, 10),
                    Sets.newHashSet(3, 9, 10),
                    Sets.newHashSet(4, 8, 10)
            )
    );

    public static ArrayList<Set<Integer>> deltaN3K3Free = new ArrayList<Set<Integer>>(
            Arrays.asList(
                    Sets.newHashSet(1, 2, 7),
                    Sets.newHashSet(1, 3, 7),
                    Sets.newHashSet(2, 3, 7),
                    Sets.newHashSet(4, 5, 7),
                    Sets.newHashSet(4, 6, 7),
                    Sets.newHashSet(5, 6, 7)
            )
    );

    public static ArrayList<Set<Integer>> deltaN2K3Free = new ArrayList<Set<Integer>>(
            Arrays.asList(
                    Sets.newHashSet(1, 2),
                    Sets.newHashSet(1, 3),
                    Sets.newHashSet(2, 3),
                    Sets.newHashSet(4, 5),
                    Sets.newHashSet(4, 6),
                    Sets.newHashSet(5, 6)
            )
    );

    public static ArrayList<Set<Integer>> deltaN2K3Free2 = new ArrayList<Set<Integer>>(
            Arrays.asList(
                    Sets.newHashSet(1, 2),
                    Sets.newHashSet(1, 3),
                    Sets.newHashSet(2, 3)
            )
    );

    public static ArrayList<Set<Integer>> deltaN3K3Free2 = new ArrayList<Set<Integer>>(
            Arrays.asList(
                    Sets.newHashSet(1, 5, 6),
                    Sets.newHashSet(1, 4, 6),
                    Sets.newHashSet(1, 2, 3),
                    Sets.newHashSet(1, 2, 4),
                    Sets.newHashSet(2, 4, 5),
                    Sets.newHashSet(2, 5, 6),
                    Sets.newHashSet(2, 3, 6),
                    Sets.newHashSet(3, 4, 6),
                    Sets.newHashSet(3, 4, 5),
                    Sets.newHashSet(1, 3, 5),
                    Sets.newHashSet(7, 11, 12),
                    Sets.newHashSet(7, 10, 12),
                    Sets.newHashSet(7, 8, 9),
                    Sets.newHashSet(7, 8, 10),
                    Sets.newHashSet(8, 10, 11),
                    Sets.newHashSet(8, 11, 12),
                    Sets.newHashSet(8, 9, 12),
                    Sets.newHashSet(9, 10, 12),
                    Sets.newHashSet(9, 10, 11),
                    Sets.newHashSet(7, 9, 11)
            )
    );
}
