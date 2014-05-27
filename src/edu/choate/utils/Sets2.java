package edu.choate.utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Yicheng on 5/13/2014.
 */
public class Sets2
{

    public static <T> Collection<Set<T>> getSubsets(final Collection<T> superSet, final int k)
    {
        return Sets.filter(Sets.powerSet(Sets.newHashSet(superSet)), new CollectionSizePredicate(k));
    }

}

class CollectionSizePredicate implements Predicate<Collection>
{
    private int size;

    public CollectionSizePredicate(int incomingSize)
    {
        size = incomingSize;
    }

    @Override
    public boolean apply(Collection incomingCollection)
    {
        boolean outgoingHasValidSizeDecision = false;
        if (incomingCollection.size() == size)
        {
            outgoingHasValidSizeDecision = true;
        }
        return outgoingHasValidSizeDecision;
    }
}
