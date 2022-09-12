package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        // person -> amount borrowed/owed
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            // person gave money, hence the debit (-)
            map.put(t[0], map.getOrDefault(t[0], 0)-t[2]);
            // person got money, hence the credit (+)
            map.put(t[1], map.getOrDefault(t[1], 0)+t[2]);
        }
        // we only care about all the debt values to find min transactions
        return settle(new ArrayList<>(map.values()), 0);
    }

    private int settle(List<Integer> debt, int start) {
        // ignore all debts that are 0
        while (start < debt.size() && debt.get(start) == 0) {
            start++;
        }
        if (start == debt.size()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i=start+1; i<debt.size(); i++) {
            // after start, find an i that has the opposite sign as start
            if (debt.get(start) * debt.get(i) < 0) {
                // assume i has taken over all of start's debt, thereby settling start
                debt.set(i, debt.get(i)+debt.get(start));
                // recurse to find the min number of transactions from start+1
                // since only start's debt is settled with the current transaction
                min = Math.min(min, 1+settle(debt, start+1));
                // once the min has been determined, reset i's debt to see
                // if there is a different i that can yield min transactions
                debt.set(i, debt.get(i)-debt.get(start));
            }
        }
        return min;
    }
}
