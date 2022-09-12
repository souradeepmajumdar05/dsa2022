package amazon;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        //System.out.println(coinChange(new int[]{1,2,5},11));
        // System.out.println(coinChangeLC(new int[]{1,2,5},11));
        System.out.println(coinChangeEnhance(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2},3));
        System.out.println(coinChangeEnhance(new int[]{2}, 3));
        System.out.println(coinChangeEnhance(new int[]{1}, 2));
//        System.out.println(coinChange(new int[]{1,2147483647},2));
        // System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
        //         System.out.println(coinChangeLC(new int[]{186,419,83,408}, 6249));
    }

    private static int coinChangeEnhance(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];
        memo[0] = -1;
        for (int i = 0; i <= amount; i++) {
            if (memo[i] != 0) {
                if (i == 0) {
                    memo[i] = 0;  //reset
                }
                for (int coin : coins) {
                    int temp = memo[i] + 1;
                    if (0 < i + coin  && i + coin < memo.length && (memo[i + coin] == 0 || memo[i + coin] > temp)) {
                        memo[i + coin] = temp;
                    }

                }
            }
        }

        return memo[amount] > 0 ? memo[amount] : -1;
    }
/////////////////////////////////////////////////////////////////////
    static List<Integer>[] memo = null;

    public static List<Integer> coinChange(int[] coins, int amount) {
        initializeMemo(amount);
        helper(coins, amount);
        System.out.println("size : " + memo[amount].size());
        System.out.println("sum : " + memo[amount].stream().reduce(0, Integer::sum));
        return memo[amount];
    }

    public static void helper(int[] coins, int amount) {
        for (int i = 0; i <= amount; i++) {
            if (memo[i] != null) {
                for (int coin : coins) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(memo[i]);
                    temp.add(coin);
                    if (i + coin > 0 && i + coin < memo.length && (memo[i + coin] == null || memo[i + coin].size() > temp.size())) {
                        memo[i + coin] = temp;
                    }
                }
            }
        }
    }

    public static void initializeMemo(int amount) {
        memo = new List[amount + 1];
        memo[0] = new ArrayList<>();
    }
////////////////////////////////////////////////////////
    public static int coinChangeLC(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin == i) {
                    min = 1;
                } else if (coin < i && memo[i - coin] > 0) {
                    min = Math.min(min, memo[i - coin] + 1);
                }
            }
            memo[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return memo[amount] > 0 ? memo[amount] : -1;
    }
}
