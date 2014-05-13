package edu.choate;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by dongcarl on 5/13/14.
 */
public class IntersectionUtils
{
	public static SetFamily allIntersectionsOf(SetFamily setFamily)
	{
		SetFamily outgoingIntersections = new SetFamily();

		for (int i = 0; i < setFamily.size(); i++)
		{
			for (int v = i; v < setFamily.size(); v++)
			{
				outgoingIntersections.add(setFamily.get(i).intersection(setFamily.get(v)));
			}
		}

		return outgoingIntersections;
	}

	public static ArrayList<IntersectionGraphWrapper> allIntersectionGraphsOf()
	{

	}
}
