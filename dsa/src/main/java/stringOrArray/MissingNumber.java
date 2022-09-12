package stringOrArray;

public class MissingNumber {
    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{3,0,1}));
    }
    public static int missingNumber(int[] nums) {
        int actualSum=0;
        for(int i=1;i<=nums.length;i++){
            actualSum+=i;
        }
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return actualSum-sum;
    }
}
