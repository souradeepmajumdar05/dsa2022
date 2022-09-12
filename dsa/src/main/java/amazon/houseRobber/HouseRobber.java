package amazon.houseRobber;

public class HouseRobber {

    public static void main(String [] args){
        System.out.println (rob(new int[]{1,2,3,1}));
    }


    public static int rob(int[] nums)
    {
        int rob1=0;
        int rob2=0;
        for(int i=0; i<nums.length; i++)
        {
            int temp=Math.max(nums[i]+rob1,rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }


}
