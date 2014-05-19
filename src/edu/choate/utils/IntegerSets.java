package edu.choate.utils;

import com.google.common.collect.Sets;
import edu.choate.structures.SetFamily;
import edu.choate.structures.IntegerSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yicheng on 5/13/2014.
 */
public class IntegerSets
{

//    //Submitted by amit at http://stackoverflow.com/questions/12548312/find-all-subsets-of-length-k-in-an-array on Sep 22 '12 at 23:02
//    private static void getSubsets(Set<Integer> superSet, int k, int idx, Set<Integer> current,SetFamily solution) {
//        //successful stop clause
//        if (current.size() == k) {
//            solution.add(new HashSet<Integer>(current));
//            return;
//        }
//        //unseccessful stop clause
//        if (idx == superSet.size()) return;
//        Integer x = superSet.get(idx);
//        current.add(x);
//        //"guess" x is in the subset
//        getSubsets(superSet, k, idx+1, current, solution);
//        current.remove(x);
//        //"guess" x is not in the subset
//        getSubsets(superSet, k, idx+1, current, solution);
//    }

    public static Set<Set<Integer>> getSubsets(Set<Integer> superSet, int k) {
//        SetFamily res = new SetFamily(k);
//        getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
//        return res;
	    Set<Set<Integer>> setFamily = new HashSet<Set<Integer>>();
	    for (Set<Integer> s : Sets.powerSet(superSet))
	    {
		    if (s.size() == k)
		    {
			    setFamily.add(s);
		    }
	    }
	    return setFamily;
    }
}
