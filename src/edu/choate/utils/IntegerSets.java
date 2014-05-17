package edu.choate.utils;

import edu.choate.structures.SetFamily;
import edu.choate.structures.IntegerSet;

import java.util.ArrayList;

/**
 * Created by Yicheng on 5/13/2014.
 */
public class IntegerSets
{

    //Submitted by amit at http://stackoverflow.com/questions/12548312/find-all-subsets-of-length-k-in-an-array on Sep 22 '12 at 23:02
    private static void getSubsets(IntegerSet superSet, int k, int idx, IntegerSet current,SetFamily solution) {
        //successful stop clause
        if (current.size() == k) {
            solution.add(new IntegerSet(current));
            return;
        }
        //unseccessful stop clause
        if (idx == superSet.size()) return;
        Integer x = superSet.get(idx);
        current.add(x);
        //"guess" x is in the subset
        getSubsets(superSet, k, idx+1, current, solution);
        current.remove(x);
        //"guess" x is not in the subset
        getSubsets(superSet, k, idx+1, current, solution);
    }

    public static SetFamily getSubsets(IntegerSet superSet, int k) {
        SetFamily res = new SetFamily(k);
        getSubsets(superSet, k, 0, new IntegerSet(), res);
        return res;
    }
}
