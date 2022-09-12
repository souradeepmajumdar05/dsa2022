package stringOrArray;

public class TrappingRainWater {
    public static void main(String[] args){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int l=0,r=height.length-1,res=0;
        int leftMax=height[l];
        int rightMax=height[r];
        while (l<r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }else {
                r--;
                rightMax = Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        return res;
    }
}
