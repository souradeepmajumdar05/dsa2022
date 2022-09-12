package dynamicPrograming;

public class PaintHouse {
    public static void main(String[] args){
        System.out.println(paintHouse(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }

    private static int paintHouse(int[][] costs) {
        int [] dp = new int[costs.length];
        for(int i=0;i<costs.length;i++){
            int dp1=costs[i][0]+Math.min(dp[1],dp[2]);
            int dp2=costs[i][1]+Math.min(dp[0],dp[2]);
            int dp3=costs[i][2]+Math.min(dp[1],dp[0]);
            dp=new int[]{dp1,dp2,dp3};
        }
        return Math.min(Math.min(dp[0],dp[1]),dp[2]);
    }
}
