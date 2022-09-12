package stringOrArray;

public class SearchInRotatedSortedArrayTwo {
    public static void main(String[]args){
        //System.out.println(search(new int[]{1,0,1,1,1},0));
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13));
    }
    public static boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;

            if(nums[left]<nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                left++;
            }
        }

        return false;
    }
}
