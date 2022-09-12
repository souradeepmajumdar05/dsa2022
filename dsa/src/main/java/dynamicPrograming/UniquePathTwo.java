package dynamicPrograming;

public class UniquePathTwo {

    public static void main(String[] args){
       // System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0},{0,0}}));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if((obstacleGrid.length==1 || obstacleGrid[0].length==1) &&
                (obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1))
            return 0;
        if(obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;
        if((obstacleGrid.length==1 || obstacleGrid[0].length==1) && obstacleGrid[0][0]==0)
            return 1;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][]arr=new int[m][n];
        arr[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j+1<n && obstacleGrid[i][j+1]==0){
                    arr[i][j+1]+=arr[i][j];
                }
                if(i+1<m && obstacleGrid[i+1][j]==0){
                    arr[i+1][j]+=arr[i][j];
                }
            }
        }
        return arr[m-1][n-1];

    }
}
