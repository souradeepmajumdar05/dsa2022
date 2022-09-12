package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PairFromGiveListWithSum {
    public static void main(String[] args) {
        PairFromGiveListWithSum pairFromGiveListWithSum = new PairFromGiveListWithSum();
        List<int[]> listArray = pairFromGiveListWithSum.findPairs(new int[][]{{1, 8}, {2, 15}, {3, 9}},
                                                                  new int[][]{{1, 8}, {2, 11}, {3, 12}},
                                                           20);
        for (int[] arr : listArray) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<int[]> findPairs(int[][] a, int[][] b, int target) {

        Arrays.sort(a, (int[] o1, int[] o2) -> o1[1] - o2[1]);
        Arrays.sort(b, (int[] o1, int[] o2) -> o1[1] - o2[1]);

        List<int[]> res = new ArrayList<>();
        int i = 0,
                j = a.length - 1;
        int max = 0;

        while (i < b.length && j >= 0)
        {
            if (a[j][1] + b[i][1] > target)
            {
                j--;
            }
            else
            {
                if (a[j][1] + b[i][1] > max)
                {
                    max = a[j][1] + b[i][1];
                    res.clear();
                    res.add(new int[]{a[j][0], b[i][0]});
                }
                else if (a[j][1] + b[i][1] == max)
                {
                    res.add(new int[]{a[j][0], b[i][0]});
                }
                i++;
            }
        }
        return res;
    }

}
