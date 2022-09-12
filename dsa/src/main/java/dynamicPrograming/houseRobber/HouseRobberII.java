package dynamicPrograming.houseRobber;

public class HouseRobberII {

    //same as houserobber 1 but here it is cyclic so to exclude the start and end value we run two subset
    //and find max at the end
    public static void main(String [] args){
        System.out.println (rob(new int[]{1,2,3,1}));
    }


    public static int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public static int rob(int[] nums,int start,int end) {
        int rob1=0;
        int rob2=0;
        for(int i=start; i<end; i++){
            int temp=Math.max(nums[i]+rob1,rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }


}
