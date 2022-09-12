package dynamicPrograming;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args){
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,5}));
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        Set<Integer> dp = new HashSet<Integer>();
        int target = sum/2;
        dp.add(0);
        for(int i =nums.length-1;i>=0;i--){
            Set<Integer> tempdp = new HashSet<Integer>();
            for(int num:dp){
                tempdp.add(nums[i] + num);
                tempdp.add(num);
            }
            dp=tempdp;
        }
        return dp.contains(target);
    }
}
