package dynamicPrograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChangeTwo {
    static List<List<Integer>>[] memo=null;
    public static void main(String[] args) {
        System.out.println(change(new int[]{1,2,5},5));
        // System.out.println(coinChangeLC(new int[]{1,2,5},11));
//        System.out.println(coinChangeEnhance(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2},3));
//        System.out.println(coinChangeEnhance(new int[]{2}, 3));
//        System.out.println(coinChangeEnhance(new int[]{1}, 2));
//        System.out.println(coinChange(new int[]{1,2147483647},2));
        // System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
        //         System.out.println(coinChangeLC(new int[]{186,419,83,408}, 6249));
    }
    public static int change(int[] coins, int amount )
    {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = 1;i <= amount; i++)
                if(i - coin >= 0)
                    dp[i] += dp[i-coin];
        }
        return dp[amount];


    }
    public static void initialization(int amount){
        memo=new List[amount +1];
        memo[0]=new ArrayList<List<Integer>>();
    }
}
