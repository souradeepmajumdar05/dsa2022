package stringOrArray;

public class ContainerWithMostWater {
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7 }));
    }
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1,max=0,res=0;
        while (l<r){
            if(height[l]<=height[r]){
                res=(r-l) * height[l];
                l++;
            }else{
                res=(r-l) * height[r];
                r--;
            }
            max=max>res?max:res;
        }
        return max;
    }
}
