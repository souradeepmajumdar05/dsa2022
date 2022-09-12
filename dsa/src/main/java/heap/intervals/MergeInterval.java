package heap.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public  static void main(String[] args){
        System.out.println(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }
    public static int[][] merge(int[][] intervalsArr) {
        if (intervalsArr == null || intervalsArr.length <= 1) {
            return intervalsArr;
        }

        List<int[]> intervals = new ArrayList<int[]>();
        for (int[] arr : intervalsArr) {
            intervals.add(arr);
        }

////////////////////////////////////////////////////////////////////////////////////
        Collections.sort(intervals, Comparator.comparing((int[] itl) -> itl[0]));

        List<int[]> result = new ArrayList<>();
        int[] t = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] c = intervals.get(i);
            if (c[0] <= t[1]) {
                t[1] = Math.max(t[1], c[1]);
            } else {
                result.add(t);
                t = c;
            }
        }
        result.add(t);
//////////////////////////////////////////////////////////////////////////////
        int[][] finalRes = new int[result.size()][2];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i][0] = result.get(i)[0];
            finalRes[i][1] = result.get(i)[1];
        }

        return finalRes;
    }
}
