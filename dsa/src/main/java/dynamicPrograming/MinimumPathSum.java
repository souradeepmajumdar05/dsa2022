package dynamicPrograming;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length+1];
        for(int i =0;i<dp.length;i++){
            dp[i]=10000;
        }
        //edge case
        dp[dp.length-2]=0;
        for(int i=grid.length-1 ; i>=0 ; i--){
            for(int j=grid[i].length-1 ; j>=0 ; j--){
                dp[j]=Math.min(grid[i][j]+dp[j],grid[i][j]+dp[j+1]);
            }
        }
        return dp[0];
    }
}
