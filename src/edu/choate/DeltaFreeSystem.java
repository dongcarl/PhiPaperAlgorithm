///**
// *
// */
//package edu.choate;
//
//import java.util.Arrays;
//
///**
// * This class simulates a family of sets that is delta(n) free for some
// * given value of n.
// * @author mbardoe
// *
// */
//public class DeltaFreeSystem extends SetFamily
//{
//
//	public static void main(String[] args)
//    {
//        SetFamily deltaFree3System = new SetFamily(3);
//        SetFamily hasDelta3System = new SetFamily(3);
//
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,2,9)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,7)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,7,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,4,8)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,5,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,7,8)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,9,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,4,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,6,9)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,9,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,5,8)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,8,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,6,9)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,7,8)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,9,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,8,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(7,10,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,7)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,3,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,4,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,6,9)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,9,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,5,6)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,6,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(2,8,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,4,7)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,5,9)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,7,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(3,10,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,7,10)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(4,10,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,6,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(5,8,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,7,8)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(6,8,11)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(9,11,12)));
//	    deltaFree3System.add(new IntegerSet(Arrays.asList(1,5,11)));
////        deltaFree3System.add(new IntegerSet(Arrays.asList(5, 6, 7)));
//
//
//        hasDelta3System.n = 3;
//        hasDelta3System.add(new IntegerSet(Arrays.asList(1, 2, 3)));
//        hasDelta3System.add(new IntegerSet(Arrays.asList(4, 5, 6)));
//        hasDelta3System.add(new IntegerSet(Arrays.asList(7, 8, 9)));
//
//
//        DeltaFreeSystem deltaFree3SystemReal = new DeltaFreeSystem(3, 4, deltaFree3System);
//	    System.out.println("Here are the intersection graphs for this delta system:");
//	    for (IntersectionGraphWrapper g : deltaFree3SystemReal.intersectionGraphs.wrappedIntersectionGraphFamily)
//	    {
//		    System.out.println(g.wrappedGraph);
//	    }
//
//        DeltaFreeSystem hasDelta3SystemReal = new DeltaFreeSystem(3, 3, hasDelta3System);
//
//        System.out.println(deltaFree3SystemReal);
//        System.out.println(deltaFree3SystemReal.containsDelta());
//
//        System.out.println(hasDelta3SystemReal);
//        System.out.println(hasDelta3SystemReal.containsDelta());
//    }
//
//}