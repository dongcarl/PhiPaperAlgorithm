package edu.choate.utils;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * Created by Yicheng on 5/21/2014.
 */
public class Logger
{
    private static final char startSym = '└';
    private static final String midSym = "──";

    public static void log(Object o, int incomingLevel)
    {
        Preconditions.checkArgument(incomingLevel >= 0, "You can't have negative level of indentation");
        StringBuilder stringToOutput = new StringBuilder(prefixSymbols(incomingLevel));
        if (o.getClass().isArray() && o.getClass().getComponentType().isPrimitive())
        {
            if (o instanceof int[])
            {
                int[] realO = ((int[]) o);
                stringToOutput.append(Arrays.toString(realO));
            }
            else
            {
                stringToOutput.append("Logging for this type of primitive array");
            }
        }
        else
        {
            stringToOutput.append(o);
        }
        System.out.println(stringToOutput);
    }

    public static StringBuilder prefixSymbols(int numSymbols)
    {
        StringBuilder outgoingStringBuilder = new StringBuilder();
        for (int i = 0; i < numSymbols; i++)
        {
            if (i == 0)
            {
                outgoingStringBuilder.append(startSym);
                outgoingStringBuilder.append(midSym);
            }
            else
            {
                outgoingStringBuilder.append(midSym);
            }
        }
        return outgoingStringBuilder;
    }
}
