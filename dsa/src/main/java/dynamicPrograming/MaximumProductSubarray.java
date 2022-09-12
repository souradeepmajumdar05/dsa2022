package dynamicPrograming;

public class MaximumProductSubarray {
    public static void main(String[] args){
        System.out.println(maxProduct(new int[]{-2,3,-4}));
    }
    public static int maxProduct(int[] nums) {
        int min=1;
        int max=1;
        int res=Integer.MIN_VALUE;
        for(int i=0 ; i < nums.length ;i++){
            res = nums[i]>res?nums[i]:res;
        }
        for(int n : nums){
            int temp = max * n;
            max=Math.max(n,Math.max(min*n,max*n));
            min=Math.min(n,Math.min(min*n,temp));
            res=Math.max(res,max);
        }
        return res;
    }
}
