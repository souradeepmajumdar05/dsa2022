package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofDaystoEatNOranges {
    Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
    public int minDays(int n) {

        dp.put(0,0);
        dp.put(1,1);
        return dfs(n);
    }
    public int dfs(int n){
        if(dp.get(n)!=null)
            return dp.get(n);
        int one=1 +(n%2) + dfs(n/2);
        int two=1 +(n%3) + dfs(n/3);
        dp.put(n,Math.min(one,two));
        return dp.get(n);
    }
}
