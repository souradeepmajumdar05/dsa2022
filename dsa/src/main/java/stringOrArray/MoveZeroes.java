package stringOrArray;

public class MoveZeroes {
    public static void main(String[] args){
        //int[] temp=new int[]{0,1,0,3,12};
       // int[] temp=new int[]{0,1};
        int[] temp=new int[]{0,0,1};
        //int[] temp=new int[]{0,0,1};
        moveZeroes(temp);
        for (int i=0 ; i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
    public  static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length)
        {
            if(nums[j]!=0){
                nums[i++]=nums[j];
            }
            j++;
        }
        while(i<nums.length){
            nums[i++]=0;
        }
    }
}
