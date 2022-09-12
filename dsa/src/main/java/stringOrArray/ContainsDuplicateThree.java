package stringOrArray;

import java.util.*;

public class ContainsDuplicateThree {
    public static void main(String [] args){
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
 //       System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
 //       System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2, 3));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647},1, 1));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set =new HashSet<>();
        for (int n:nums){
            set.add(n);
        }
        if(t==0 && nums.length==set.size())
            return false;

        for (int i=0 ;i<nums.length ; i++)
        {
            for(int j=i+1 ; j-i<=k && j<nums.length ; j++)
            {
                double a= nums[i];
                double b= nums[j];
                if (Math.abs(a-b)<=t){
                    return true;
                }

            }
        }
        return false;
    }
}
