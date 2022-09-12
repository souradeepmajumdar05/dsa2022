package stringOrArray;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea =0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i< heights.length;i++){
            int start =i;
            while(!stack.empty() && stack.peek()[1]> heights[i]){
                int[] temp= stack.pop();
                int index = temp[0];
                int height = temp[1];
                maxArea= Math.max(maxArea, height * (i-index));
                start=index;
            }
            stack.add(new int[]{start,heights[i]});
        }
        while(!stack.empty()){
            int[] temp= stack.pop();
            int index = temp[0];
            int height = temp[1];
            maxArea= Math.max(maxArea, height * (heights.length-index));
        }
        return maxArea;
    }

}
