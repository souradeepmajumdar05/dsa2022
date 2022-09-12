package stringOrArray;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args){
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
    public static int findMin(int[] nums) {
        int res=nums[0];
        int l=0,r=nums.length-1;
        while(l<=r){
            if(nums[l]<nums[r]){
                res= Math.min(res,nums[l]);
            }
            int m=(l+r)/2;
            res= Math.min(res,nums[m]);
            if(nums[m]>nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return res;
    }
}
