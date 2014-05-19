package edu.choate.structures;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by dongcarl on 4/22/14.
 */
public class rVector extends Vector<Integer>
{
	public rVector()
	{
		super();
	}

    public rVector(Integer... a)
    {
        super(Arrays.asList(a));
    }
}