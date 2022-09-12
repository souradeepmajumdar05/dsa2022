package stringOrArray;

public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length <= 2){
            return nums.length;
        }
        int i=1;
        int j=2;
        while(j<nums.length){
            if(nums[i]==nums[j]&&nums[i-1]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
}
