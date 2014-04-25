package edu.choate;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A collection of tools and methods that work well 
 * IntegerSets
 * @author mbardoe
 *
 */
public class SetTools {
/**
 * The class method returns a complete list  of IntegerSets whose values vary from 0 to 
 * n-1, and are all of size of k. It is returned in an ArrayList.
 * @param n the number of entries for the various sets
 * @param k the size of each set
 * @return an ArrayList of the n choose k sets of size k.
 */
	public static ArrayList<IntegerSet> nSetMaker(int n, int k)
	{
		//		"""Makes sets of size k from the given list of elements 0 to n-1"""
		//        # this will store the sets as we make them
		
		ArrayList<IntegerSet> ans = new ArrayList<IntegerSet>();

		//        # this is a list containing the various positions that will be used for each set
		//        # start with the first n and eventually we will end with the last n.
		
		// first set to be added and then updated.
		int[] position = new int[k];
		for (int i=0; i< k;i++)
		{
			position[i]=i;
		}
		// last set to be added and then break
		int[] endposition = new int[k];
		for (int i=n-1; i>n-k-1; i--)
		{
			endposition[i-n+k]=i;
		}
		int j;
		while (true)
		{


			//            # add set to the final answer
			ans.add(new IntegerSet(position));
			//            # if we have the last set then exit
			if (Arrays.equals(position, endposition))
			{
				break;
			}
			//            # prepare to change the positions
			boolean flag = true;
			//            # start at the back position
			j=k-1;
			while (flag)
			{


				//                #print position
				//                # increment the last position
				position[j]+=1;
				//                # don't let it get too big. if we are reseting an earlier one make all
				//                # subsequent ones be consecutive.
				//                if position[i]<len(mylist)+i+1:
				if (position[j]<j+n-k+1)
				{
					for (int m=j+1; m<k; m++)
					{
						//                        # Found the best place to shift now make everything that comes after
						//                        # that as small as possible
						position[m]=position[m-1]+1;
						
					}
					flag=false;
				}
				else
				{
					j-=1;
				}
				//                    # move to a previous place
			}
		}
		return ans;
	}


	public static void main(String[] args)
	{
		ArrayList<IntegerSet> x = SetTools.nSetMaker(4,2);
		System.out.println(x);
		
	}


}
