package edu.choate.utils;

import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Yicheng on 5/20/2014.
 */
public class GridCollections
{
    public static <T> int widthOf(Collection<? extends Collection<T>> incomingGridCollection)
    {
        Preconditions.checkArgument(hasConsistentWidth(incomingGridCollection),
                "GridCollections.widthOf was called with an incomingGridCollection which doesn't have consistent width");
        return incomingGridCollection.iterator().next().size();
    }

    public static <T> boolean hasConsistentWidth(Collection<? extends Collection<T>> incomingGridCollection)
    {
        boolean outgoingHasConsistentWidth = true;
        Collection<T> first = incomingGridCollection.iterator().next();
        for (Iterator<? extends Collection<T>> iterator = incomingGridCollection.iterator(); iterator.hasNext() && outgoingHasConsistentWidth;)
        {
            Collection<T> current = iterator.next();
            if (first.size() != current.size())
            {
                outgoingHasConsistentWidth = false;
            }
        }
        return outgoingHasConsistentWidth;
    }
}
