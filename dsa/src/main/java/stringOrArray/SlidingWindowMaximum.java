package stringOrArray;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static void main(String [] args){
        int[] result=maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
//        int[] result=maxSlidingWindow(new int[]{7,2,4},2);
        for(int i:result){
            System.out.println(i);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int l=0,r=0;
        while(r<nums.length){

            queue.add(r);
            if(l>queue.peek()){
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peek()]<nums[r]){
                queue.poll();
            }
            if((r+1)>=k){
                res[l++]=nums[queue.peek()];
            }
            r++;
        }
        return res;
    }
}
