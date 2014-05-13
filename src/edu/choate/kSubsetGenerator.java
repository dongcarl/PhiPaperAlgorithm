package edu.choate;

/**
 * Created by Yicheng on 5/13/2014.
 */
public class kSubsetGenerator
{
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
        SetFamily res = new SetFamily();
        getSubsets(superSet, k, 0, new IntegerSet(), res);
        return res;
    }
}
