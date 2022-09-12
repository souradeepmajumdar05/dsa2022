package stringOrArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InsertInterval {
    public static void main(String[] args) {
        // int[][]res=insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        int[][] res = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " , " + res[i][1]);
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            //new newInterval goes before current interval
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                return finalValue(i, intervals, res);
            }
            //new newInterval goes after current interval
            else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            }
            //overlap case
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        return finalValue(-1, intervals, res);
    }

    private static int[][] finalValue(int i, int[][] intervals, List<int[]> res) {
        int[][] resArr = null;
        if (i == -1) {
            resArr = new int[res.size()][2];
            for (int j = 0; j < res.size(); j++) {
                resArr[j][0] = res.get(j)[0];
                resArr[j][1] = res.get(j)[1];
            }
        } else {
            resArr = new int[res.size() + intervals.length - i][2];
            int k = 0;
            for (int j = 0; j < res.size(); j++) {
                resArr[j][0] = res.get(j)[0];
                resArr[j][1] = res.get(j)[1];
                k = j;
            }
            k++;
            for (int j = k; j < resArr.length; j++) {
                resArr[j][0] = intervals[i][0];
                resArr[j][1] = intervals[i][1];
                i++;
            }
        }
        return resArr;
    }
}
