package edu.choate.learn;

import com.google.common.base.Preconditions;
import edu.choate.utils.IntArrays;
import edu.choate.utils.rVectors;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by dongcarl on 4/22/14.
 */

public class rVectorProximityHeuristicComparator implements Comparator<Collection<Integer>>
{
    private static int[] idealVector;
    private static Collection<? extends Collection<Integer>> entireSet;

    public rVectorProximityHeuristicComparator(int[] incomingIdealVector, Collection<? extends Collection<Integer>> incomingEntireSet, int incomingN)
    {
        idealVector = incomingIdealVector;
        entireSet = incomingEntireSet;
    }

    public rVectorProximityHeuristicComparator()
    {
        super();
    }


    @Override
    public int compare(Collection<Integer> incomingTreeSetOfInteger1, Collection<Integer> incomingTreeSetOfInteger2)
    {
        Preconditions.checkArgument(incomingTreeSetOfInteger1.size() == incomingTreeSetOfInteger2.size(),
                "Comparing two sets of integers with different sizes");
        return
                Double.compare(
                        IntArrays.euclideanDistance(rVectorOf(incomingTreeSetOfInteger1), idealVector),
                        IntArrays.euclideanDistance(rVectorOf(incomingTreeSetOfInteger2), idealVector)
                );
    }

    public int[] rVectorOf(Collection<Integer> incomingElement)
    {
        Preconditions.checkNotNull(entireSet, "Asking for the rVector of a set of integers from an instance with no knowledge of what the entire set is");
        return rVectors.rVectorOf(incomingElement, entireSet);
    }
}
