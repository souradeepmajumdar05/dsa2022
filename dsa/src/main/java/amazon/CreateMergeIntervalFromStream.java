package amazon;

import java.util.*;

public class CreateMergeIntervalFromStream {
    public static void main(String[] args) {
        int[] nums = {1,3,2,7,9,5,6,4,8};
        List<int[]> intervals = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            intervals = mergeInterval(nums[i], intervals);
            for(int j=0;j<intervals.size();j++)
                System.out.print(Arrays.toString(intervals.get(j)) + (j == intervals.size()-1 ? "" : ","));
            System.out.println();
        }
    }

    private static List<int[]> mergeInterval(int num, List<int[]> intervals)
    {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
        minHeap.addAll(intervals);
        minHeap.add(new int[] {num, num});
        int[] first = minHeap.poll();
        List<int[]> res = new ArrayList<>();
        while(!minHeap.isEmpty())
        {
            int[] cur = minHeap.poll();
            if(first[1] >= cur[0] - 1)
            {
                first[1] = Math.max(first[1], cur[1]);
                continue;
            }
            else
            {
                res.add(first);
                first = cur;
            }
        }
        res.add(first);
        return res;
    }
}
