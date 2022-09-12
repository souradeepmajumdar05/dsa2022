package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    public static void main(String[]args){
        //System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJumpGreedy(new int[]{2,3,1,1,4}));
        //System.out.println(canJump(new int[]{3,2,1,0,4}));
        //System.out.println(canJump(new int[]{2,0}));
        //System.out.println(canJump(new int[]{2,0,0}));
    }

    public static boolean canJumpGreedy(int[] nums) {
        int goal = nums.length-1;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(nums[i]+i >= goal)
                goal=i;
        }
        return goal == 0 ? true : false;
    }

    ///////////////////time limit execced////////////////////
    ////////////////////// dynamic programing///////////////
    static Map<Integer,Boolean> dp;
    static int[] nums;
    public static boolean canJump(int[] nums) {
        dp = new HashMap<Integer,Boolean>();
        JumpGame.nums=nums;
        return helper(0);
    }
    public static boolean helper(int pos){
        if(dp.get(pos)!=null)
            return dp.get(pos);

        if(pos>=nums.length-1)
            return true;

        if(nums[pos] == 0)
            return false;

        for(int i=1;i<=nums[pos];i++)
        {
            if((pos+i) < nums.length ){
                dp.put(pos+i,helper(pos+i));
            }
            else if ((pos+i) >= nums.length){
                dp.put(pos+i,true);
            }
            if(dp.get(pos+i)==true)
                return true;
        }
        dp.put(pos,false);
        return false;
    }
///////////////////////////////////////////////////////
}
