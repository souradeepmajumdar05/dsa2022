package dynamicPrograming;

public class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
         long sumEven=0;
         long sumOdd=0;
         for(int i=nums.length-1;i>=0;i--){
             long tmpEven=Math.max(sumOdd+nums[i],sumEven);
             long tmpOdd=Math.max(sumEven-nums[i],sumOdd);
             sumEven=tmpEven;
             sumOdd=tmpOdd;
         }
         return sumEven;

     }
}
