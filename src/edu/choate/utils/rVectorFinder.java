package edu.choate.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Collection;

/**
 * Created by Yicheng on 5/25/2014.
 */
public class rVectorFinder<T>
{
    private final Collection<? extends Collection<T>> entireFamily;

    public rVectorFinder(Collection<? extends Collection<T>> incomingEntireFamily)
    {
        Preconditions.checkArgument(GridCollections.hasConsistentWidth(incomingEntireFamily), "rVectorFinder.rVectorFinder was called with an incomingEntireFamily with an inconsistent width");
        entireFamily = incomingEntireFamily;
    }

    public int[] find(Collection<T> incomingElement)
    {
        return find(incomingElement, entireFamily);
    }

    private int[] find(Collection<T> incomingElement, Collection<? extends Collection<T>> incomingWhole)
    {
        int widthOfIncoming = GridCollections.widthOf(incomingWhole);
        Preconditions.checkArgument(incomingElement.size() == widthOfIncoming,
                "Trying to get rVector of a set of integers which has a different size than that of sets in the collection of collections of integers");

        int[] outgoingRVector = new int[widthOfIncoming];

        for (int i = 0; i < outgoingRVector.length; i++)
        {
            int currValid = 0;
            for (Collection<T> e : incomingWhole)
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

}
