package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSelStockWithCoolDown {
    int[] prices;
    Map<String,Integer> dp = new HashMap<String,Integer>();
    public int maxProfit(int[] prices) {
        this.prices=prices;
        return dfs(0,true);
    }
    public int dfs(int i,boolean buying){
        if(i>=prices.length)
            return 0;
        if(dp.get(i+":"+buying)!=null)
            return dp.get(i+":"+buying);

        int coolDown=dfs(i+1,buying);
        if(buying){
            int buy=dfs(i+1,!buying)-prices[i];
            dp.put(i+":"+buying, Math.max(buy,coolDown));
        }else{
            int sell=dfs(i+2,!buying)+prices[i];
            dp.put(i+":"+buying, Math.max(sell,coolDown));
        }
        return dp.get(i+":"+buying);
    }
}
