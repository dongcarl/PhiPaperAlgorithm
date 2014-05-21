package edu.choate.utils;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yicheng on 5/13/2014.
 */
public class Sets2
{
    public static <T> Set<Set<T>> getSubsets(Set<T> superSet, int k)
    {
        Set<Set<T>> setFamily = new HashSet<Set<T>>();
        for (Set<T> s : Sets.powerSet(superSet))
        {
            if (s.size() == k)
            {
                setFamily.add(s);
            }
        }
        return setFamily;
    }
}
