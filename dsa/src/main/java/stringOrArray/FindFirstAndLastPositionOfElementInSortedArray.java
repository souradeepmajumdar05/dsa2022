package stringOrArray;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args){
        int[] arr=searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(arr[0]+","+arr[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int left=binarySearch(nums,target,true);
        int right=binarySearch(nums,target,false);
        return new int[]{left,right};
    }
    public static int binarySearch(int[] nums, int target,boolean leftBias){
        int i=-1;
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(target<nums[m]){
                r=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                i=m;
                if(leftBias){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return i;
    }
}
