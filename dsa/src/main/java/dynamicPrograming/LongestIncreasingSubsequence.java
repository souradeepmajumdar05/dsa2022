package dynamicPrograming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    public static int lengthOfLIS(int[] nums) {
        int [] memo = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            memo[i]=1;
        }

        for(int i=nums.length-1 ; i>=0 ; i--){
            for(int j=i+1 ; j<nums.length ;j++){
                if(nums[i]<nums[j])
                    memo[i]=Math.max(memo[i],memo[j]+1);
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<memo.length;i++){
            max= memo[i]>max?memo[i]:max;
        }
        return max;
    }
}
