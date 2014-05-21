package edu.choate.utils;

import com.google.common.base.Preconditions;

import java.util.Collection;

/**
 * Created by Yicheng on 5/20/2014.
 */
public class Collections3
{
    public static int widthOf2DCollection(Collection<? extends Collection<Integer>> incoming2DCollection)
    {
        int establishedWidth = incoming2DCollection.iterator().next().size();
        for (Collection c : incoming2DCollection)
        {
            Preconditions.checkArgument(c.size() == establishedWidth,
                    "Collections3.widthOf2DCollection was called with an incoming2DCollection which doesn't have consistent width");
        }
        return establishedWidth;
    }
}
