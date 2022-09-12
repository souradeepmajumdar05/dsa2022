package heap;

import java.util.PriorityQueue;

public class KthLargestInanArray {
    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new  PriorityQueue<Integer>(k);
        for(int i:nums){
            queue.offer(i);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.poll();
    }
}
