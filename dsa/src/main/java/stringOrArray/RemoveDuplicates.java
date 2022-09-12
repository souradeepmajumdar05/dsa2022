package stringOrArray;

public class RemoveDuplicates {
    public static void main(String[] args){
        int[] temp=new int[]{1,1,2};
        int count =removeDuplicates(temp);
        for (int i=0 ; i<count;i++){
            System.out.println(temp[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int count =0;
        int cur=-10000;
        int j=0;
        for(int i=0 ; i<nums.length ;i++){
            if(cur!=nums[i]){
                cur=nums[i];
                count++;
                nums[j++]=nums[i];
            }
        }
        return count;
    }
}
