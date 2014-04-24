package edu.choate;

import java.util.ArrayList;

/**
 * A collection of tools and methods that work well 
 * IntegerSets
 * @author mbardoe
 *
 */
public class SetTools {

	public static ArrayList<IntegerSet> nSetMaker(int n, int k)
	{
//		"""Makes sets of size n from the given list"""
//        # this will store the sets as we make them
//        ans=[]
		ArrayList<IntegerSet> ans = new ArrayList<IntegerSet>();
		
//        # this is a list containing the various positions that will be used for each set
//        # start with the first n and eventually we will end with the last n.
//        position=range(n)
		int[] position
//        # What is the largest position (+1)
//        rollover=len(mylist)
//        
//            
//        while True:
//            #create a new set
//            newset=[]
//            # put the right numbers in
//            for i in position:
//                newset.append(mylist[i])
//            # add set to the final answer
//            ans.append(set(newset))
//            
//            #print "1 ",position
//            # if we have the last set then exit
//            if position==range(len(mylist)-n,len(mylist)):
//                break
//            # prepare to change the positions
//            flag=True
//            # start at the back position
//            i=-1
//            while flag:
//                #print position
//                # increment the last position
//                position[i]+=1
//                # don't let it get too big. if we are reseting an earlier one make all
//                # subsequent ones be consecutive.
//                if position[i]<len(mylist)+i+1:
//                    for j in range(i+1,0):
//                        # Found the best place to shift now make everything that comes after
//                        # that as small as possible
//                        position[j]=position[j-1]+1
//                    flag=False
//                    #print position
//                else:
//                    # move to a previous place
//                    i-=1
//        return ans
		
	}
	
}
