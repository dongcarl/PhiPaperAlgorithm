package edu.choate.learn;

import java.util.*;

/**
 * Created by Yicheng on 5/21/2014.
 */
public class rVectorPossibilities
{
    public static ArrayList<int[]> allPossibleRVectors(int incomingN, int incomingTARGET)
    {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        ArrayList<int[]> outgoing = new ArrayList<int[]>();

        for (int i = 0; i < incomingN; i++)
        {
            sets.add(new ArrayList<Integer>());
            for (int j = 0; j < incomingTARGET; j++)
            {
                sets.get(sets.size() - 1).add(j);
            }
        }

        for (Set<Integer> s : getSetPermutations(sets))
        {
            int ind = 0;
            outgoing.add(new int[s.size()]);
            for (Integer si : s)
            {
                outgoing.get(outgoing.size() - 1)[ind++] = si;
            }
        }

        return outgoing;
    }

    public static <T> Set<Set<T>> getSetPermutations(final Collection<? extends Collection<T>> input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("Input not provided!");
        }
        final List<Set<T>> saved = new ArrayList<Set<T>>();
        for (Collection<T> c : input)
        {
            Set<T> s = new HashSet<T>(c);
            c.remove(null);
            if (c.size() >= 1)
            {
                saved.add(s);
            } else
            {
                throw new IllegalArgumentException("Input includes null/empty collection!");
            }
        }

        return permute(new HashSet<T>(), saved);
    }

    private static <T> Set<Set<T>> permute(final Set<T> initial, final List<Set<T>> itemSets)
    {

        if (itemSets.isEmpty())
        {
            return Collections.singleton(initial);
        }

        final Set<T> items = itemSets.get(0);
        final List<Set<T>> remaining = itemSets.subList(1, itemSets.size());
        final int computedSetSize = initial.size() * items.size() * remaining.size();
        final Set<Set<T>> computed = new HashSet<Set<T>>(computedSetSize, 1);

        for (T item : items)
        {
            if (!initial.contains(item))
            {
                Set<T> permutation = new HashSet<T>(initial);
                permutation.add(item);
                computed.addAll(permute(permutation, remaining));
            }
        }

        return computed;
    }
}
