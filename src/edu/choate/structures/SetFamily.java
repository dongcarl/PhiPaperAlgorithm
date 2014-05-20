//package edu.choate.structures;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by dongcarl on 4/22/14.
// * Objects of this family represent a family of sets of a specific size n.
// */
//public class SetFamily extends ArrayList<Set<Integer>> implements Set<Set<Integer>>
//{
//	public int n; // The size of each set
//
//	public SetFamily(int incomingN, ArrayList<Set<Integer>> incomingE)
//	{
//		super();
//		n = incomingN;
//		this.addAll(incomingE);
//	}
//
//	public SetFamily(int incomingN)
//	{
//		super();
//		n = incomingN;
//	}
//
//    public SetFamily(int incomingN, Set<Integer>... a)
//    {
//	    this.n = incomingN;
//        this.addAll(Arrays.asList(a));
//    }
//
//	@Override
//	public boolean equals(Object o)
//	{
//		boolean outgoingEqualsDecision = false;
//
//		if (o instanceof SetFamily)
//		{
//			SetFamily incomingSetFamily = (SetFamily)o;
//			boolean hasSameN = (this.n == incomingSetFamily.n);
//			boolean hasSameMembers = (new HashSet<Set<Integer>>(this)).equals(new HashSet<Set<Integer>>(incomingSetFamily));
//			outgoingEqualsDecision = hasSameN && hasSameMembers;
//		}
//		return outgoingEqualsDecision;
//	}
//
//	@Override
//	public boolean add(Set<Integer> integerSet)
//	{
////        System.out.println("in add:, first boolean returns: " + this.contains(integerSet));
////        System.out.println("in add:, second boolean returns: " + (integerSet.size() != this.n));
////        System.out.println("in add:, size of incoming integerSet is: " + integerSet.size());
////        System.out.println("in add:, n is: " + this.n);
//        if (this.contains(integerSet) || (integerSet.size() != this.n))
//		{
//			return false;
//		}
//		else
//		{
//			super.add(integerSet);
//			return true;
//		}
//	}
//
//	@Override
//	public void add(int index, Set<Integer> element)
//	{
//		this.add(element);
//	}
//
//
//	public Set<Integer> pop()
//	{
//		Set<Integer> outgoingIntegerSet = this.get(this.size()-1);
//		this.remove(this.size()-1);
//		return outgoingIntegerSet;
//	}
//
//}
//
