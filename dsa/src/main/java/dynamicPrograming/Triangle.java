package dynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String [] args){

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> r1 =new ArrayList<>(Arrays.asList(2));
        List<Integer> r2 =new ArrayList<>(Arrays.asList(3,4));
        List<Integer> r3 =new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> r4 =new ArrayList<>(Arrays.asList(4,1,8,3));
        triangle.add(r1);
        triangle.add(r2);
        triangle.add(r3);
        triangle.add(r4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.get(triangle.size()-1).size()+1];
        for(int i=triangle.size()-1 ; i>=0 ; i--){
            for(int j=0 ; j<= triangle.get(i).size()-1 ; j++){
                dp[j]= triangle.get(i).get(j)+ Math.min(dp[j] , dp[j+1]);
            }
        }
        return dp[0];
    }
}
