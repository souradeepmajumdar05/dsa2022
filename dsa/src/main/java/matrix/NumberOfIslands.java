package matrix;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count =0 ;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    markArea(grid,i,j);
                }
            }
        }
        return count;
    }
    public void markArea(char[][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        markArea(grid,i-1,j);
        markArea(grid,i,j-1);
        markArea(grid,i,j+1);
        markArea(grid,i+1,j);

    }
}
