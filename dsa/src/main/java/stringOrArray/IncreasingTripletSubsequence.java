package stringOrArray;

public class IncreasingTripletSubsequence {
    public static void main(String[] args){
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.print(increasingTriplet(new int[]{5,4,3,2,1}));
    }
    public static boolean increasingTriplet(int[] nums) {
        int small=Integer.MAX_VALUE;
        int large=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=small){
                small=num;
            }
            else if(num<=large){
                large=num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
