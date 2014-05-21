package edu.choate.utils;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;

/**
 * Created by dongcarl on 5/17/14.
 */
public class IntArrays
{
    public static double euclideanDistance(int[] o1, int[] o2)
    {
        Preconditions.checkArgument(o1.length == o2.length);

        long sum = 0;

        for (int i = 0; i < o1.length; i++)
        {
            sum += IntMath.checkedPow(IntMath.checkedSubtract(o1[i], o2[i]), 2);
        }

        return Math.sqrt((double) sum);
    }
}
