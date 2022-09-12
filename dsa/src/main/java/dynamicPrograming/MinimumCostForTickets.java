package dynamicPrograming;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    static int[] costs;
    static Integer[] memo;
    static Set<Integer> dayset;

    public static void main(String [] args){
       System.out.println(mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15}));
       // System.out.println(mincostTickets(new int[]{1,4,6,7,8},new int[]{2,7,15}));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        MinimumCostForTickets.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);

        return dp(1);
    }
    public static int dp(int i) {
        if (i > 365)
        //if (i > 38)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i+1) + costs[0], dp(i+7) + costs[1]);
            ans = Math.min(ans, dp(i+30) + costs[2]);
        } else {
            ans = dp(i+1);
        }

        memo[i] = ans;
        return ans;
    }

}
