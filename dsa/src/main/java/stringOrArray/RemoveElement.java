package stringOrArray;

public class RemoveElement {
    public static void main(String[] args){
        int[] temp=new int[]{3,2,2,3};
        int count =removeElement(temp,3);
        for (int i=0 ; i<count;i++){
            System.out.println(temp[i]);
        }
    }
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]!=val){
                nums[count++]=nums[i];
            }
        }
        return count;
    }
}
