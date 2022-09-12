package stringOrArray;

public class FindMinimumInRotatedSortedArrayTwo {
    public static void main(String[] args){
        System.out.println(findMin(new int[]{2,2,2,0,1}));
    }
    public static int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            while(nums[l]==nums[r] && l!=r){
                l++;
            }
            if(nums[l]<=nums[r]){
                return nums[l];
            }
            int m=(l+r)/2;
            if(nums[m]>=nums[l]){
                l=m+1;
            }else{
                r=m;
            }
        }
        return -1;
    }
}
