package stringOrArray;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String [] args){
        System.out.println(firstMissingPositive(new int[]{1}));
    }
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();
        for(int i=0 ;i<nums.length ;i++){
            set.add(nums[i]);
        }
        int n=1;
        while(n<=nums.length){
            if(set.contains(n)){
                n++;
            }else{
                break;
            }

        }

        return n;
    }
}
