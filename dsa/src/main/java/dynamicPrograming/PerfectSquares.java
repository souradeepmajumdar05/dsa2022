package dynamicPrograming;

public class PerfectSquares {

    public static void main(String[] args){
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1 ; i<=n ;i++){
            dp[i]=n;
        }
        dp[0]=0;
        for(int target =1; target<n+1 ;target++){
            for(int s=1;s<target+1 ; s++){
                int square =s*s;
                if(target-square<0){
                    break;
                }else {
                    dp[target] = Math.min(dp[target], 1 + dp[target - square]);
                }
            }
        }
        return dp[n];
    }
}
