package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class MaximalSquare {
    public static void main(String [] args){
        //System.out.println(maximalSquare(new char [][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        //System.out.println(maximalSquare(new char [][]{{'0','1'},{'1','0'}}));
        System.out.println(maximalSquare(new char [][]{{'1','1','1','1','0'},
                                                       {'1','1','1','1','0'},
                                                       {'1','1','1','1','1'},
                                                       {'1','1','1','1','1'},
                                                       {'0','0','1','1','1'}}));
    }
    static  Map<String,Integer> dp= new HashMap<>();
    static int rows=0;
    static int cols=0;
    static char[][] matrix;
    public static int maximalSquare(char[][] matrix) {
        MaximalSquare.matrix=matrix;
        rows=matrix.length;
        cols=matrix[0].length;
        helper(0,0);
        int max=-1;
        for (Integer i: dp.values()){
            max= i>max?i:max;
        }
        return max*max;
    }

    private static int helper(int r, int c) {
        if(r>=rows || c>=cols)
            return 0;
        if(dp.get(r+"+"+c)==null){
            int down = helper(r+1,c);
            int right= helper(r,c+1);
            int diag = helper(r+1,c+1);

            dp.put(r+"+"+c,0);
            if(matrix[r][c]=='1'){
                dp.put(r+"+"+c, 1+ Math.min( diag,Math.min(down,right)));
            }
        }
        return dp.get(r+"+"+c);
    }
}
