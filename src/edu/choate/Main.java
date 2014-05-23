package edu.choate;

import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main
{

    static final String schoolName = "Choate Rosemary Hall";
    static final String courseName = "MA683S-HO";
    static final double secondsToDelay = 0.25;
    static Map<String, Method> functionalities  = Maps.newHashMap();
    static List<String> stringKeyList = new ArrayList<String>();



    //Step 1



    public static void main(String[] args) throws InterruptedException
    {
        functionalities.put("Begin constructing delta systems", getMethodAndHandleExceptions("constructDeltaInteractive", null));
        functionalities.put("Check if a list of a set of integers has a delta system", getMethodAndHandleExceptions("checkDeltaInteractive", null));

        for (String s : functionalities.keySet())
        {
            stringKeyList.add(s);
        }

        System.out.printf("Welcome to %s's %s Delta System Constructor\n", schoolName, courseName);

        delay(secondsToDelay);

        System.out.printf("This is an interactive program/binary/software\n");

        try
        {
            int intSelection = selectFunctionality() - 1;
            functionalities.get(stringKeyList.get(intSelection)).invoke(null, null);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }



    }

    public static Method getMethodAndHandleExceptions(String name, Class<?>... parameterTypes)
    {
        Method outgoingMethod = null;
        try
        {
            outgoingMethod = Main.class.getMethod(name, parameterTypes);
        }
        catch (NoSuchMethodException ex)
        {
            ex.printStackTrace();
        }
        return outgoingMethod;
    }

    public static void constructDeltaInteractive()
    {
        System.out.println("Main.constructDeltaInteractive");
    }

    public static void constructSetFamilyInteractive()
    {
//        System.out.println("We're now going to construct a family of sets");
//        System.out.printf("How many items would you have to have in each set?");
//
//        int setSize = Integer.MIN_VALUE;
//        String input = getFromSysIn();
//        if (isInteger(input))
//        {
//            setSize = Integer.parseInt(input);
//        }
//        else
//        {
//            System.out.println("You didn't input a numerical size, according to conventions of early 21st century homo sapiens, a numerical size implies that it is a positive decimal integer");
//            delay(0.5);
//            setSize = constructSetFamilyInteractive();
//        }
//
//        if (setSize < 0)
//        {
//            System.out.println("Can't have a size less than zero");
//            delay(0.5);
//            setSize = constructSetFamilyInteractive();
//        }
    }

    public static void checkDeltaInteractive()
    {
        System.out.println("Main.checkDeltaInteractive");
    }

    public static int selectFunctionality()
    {
        System.out.printf("What would you like to do:\n");
        int counter = 1;
        for (String option : stringKeyList)
        {
            System.out.printf("%d. %s\n", counter, option);
            counter++;
        }
        System.out.printf("Enter a numerical selection: ");
        String input = getFromSysIn();
        int selectedOption = Integer.MIN_VALUE;
        if (isInteger(input))
        {
            selectedOption = Integer.parseInt(input);
        }
        else
        {
            System.out.println("You didn't input a numerical selection, according to conventions of early 21st century homo sapiens, a numerical selection implies that it is a decimal integer");
            delay(0.5);
            selectedOption = selectFunctionality();
        }

        if (selectedOption < 1 || selectedOption > stringKeyList.size())
        {
            System.out.println("You didn't enter a numerical selection within the range of accepted numerical selections");
            delay(0.5);
            selectedOption = selectFunctionality();
        }

        return selectedOption;
    }

    public static String getFromSysIn()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String outgoingString = null;

        try {
            outgoingString = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

        return outgoingString;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }



    public static void delay(double incomingSeconds)
    {
        try {
            Thread.sleep((long)(incomingSeconds*1000));
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}