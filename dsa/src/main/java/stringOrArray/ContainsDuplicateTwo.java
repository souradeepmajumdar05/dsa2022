package stringOrArray;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateTwo {
    public static void main(String [] args){
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(containsNearbyDuplicate(new int[]{99,99},2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0 ; i<nums.length ; i++){
            if(map.get(nums[i])!=null){
                if(Math.abs(map.get(nums[i])-i)<=k){
                    return true;
                }
            }

            map.put(nums[i],i);

        }
        return false;
    }
}
