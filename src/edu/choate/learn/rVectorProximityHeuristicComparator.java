package edu.choate.learn;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import edu.choate.utils.Collections3;
import edu.choate.utils.IntArrays;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

/**
 * Created by dongcarl on 4/22/14.
 */

public class rVectorProximityHeuristicComparator implements Comparator<Set<Integer>>
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

    public static int[] rVectorOf(Set<Integer> incomingElement, Collection<? extends Collection<Integer>> incomingWhole)
    {
        int widthOfIncoming = Collections3.widthOf2DCollection(incomingWhole);
        Preconditions.checkArgument(incomingElement.size() == widthOfIncoming,
                "Trying to get rVector of a set of integers which has a different size than that of sets in the collection of collections of integers");

        int[] outgoingRVector = new int[widthOfIncoming];

        for (int i = 0; i < outgoingRVector.length; i++)
        {
            int currValid = 0;
            for (Collection<Integer> e : incomingWhole)
            {
                if (e != incomingElement && Sets.intersection(Sets.newHashSet(e), Sets.newHashSet(incomingElement)).size() == i)
                {
                    currValid++;
                }
            }
            outgoingRVector[i] = currValid;
        }

        return outgoingRVector;
    }

    @Override
    public int compare(Set<Integer> incomingTreeSetOfInteger1, Set<Integer> incomingTreeSetOfInteger2)
    {
        Preconditions.checkArgument(incomingTreeSetOfInteger1.size() == incomingTreeSetOfInteger2.size(),
                "Comparing two sets of integers with different sizes");
        return
                Double.compare(
                        IntArrays.euclideanDistance(rVectorOf(incomingTreeSetOfInteger1), idealVector),
                        IntArrays.euclideanDistance(rVectorOf(incomingTreeSetOfInteger2), idealVector)
                );
    }

    private int[] rVectorOf(Set<Integer> incomingElement)
    {
        Preconditions.checkNotNull(entireSet, "Asking for the rVector of a set of integers from an instance with no knowledge of what the entire set is");
        return rVectorOf(incomingElement, entireSet);
    }
}
