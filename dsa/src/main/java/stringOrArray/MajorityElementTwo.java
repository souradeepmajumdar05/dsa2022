package stringOrArray;

import java.util.*;

public class MajorityElementTwo {
    public static void main(String[] args){
        //List<Integer>list= majorityElement(new int[]{2,2});
        //List<Integer>list= majorityElement(new int[]{1,2});
        List<Integer>list= majorityElement(new int[]{1,2,3});
        for(int l: list){
            System.out.print(l +" ");
        }
    }
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.get(n)==null?1:map.get(n)+1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int n:map.keySet()){
            if(map.get(n)>nums.length/3){
                list.add(n);
            }
        }
        return list;

    }

    public static List<Integer> majorityElementold(int[] nums) {
        if(nums.length==1||nums.length==2){
            Map<Integer,Integer> map=new HashMap<>();
            for(int n:nums){
                map.put(n,map.get(n)==null?1:map.get(n)+1);
            }
            List<Integer> list = new ArrayList<Integer>();
            for(int n:map.keySet()){
                if(map.get(n)>nums.length/3){
                    list.add(n);
                }
            }
            return list;

        }
        Arrays.sort(nums);
        //int n=nums.length/3;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=(nums.length/3)*2 ; i<nums.length ; i++){
            list.add(nums[i]);
        }
        return list;

    }

}
