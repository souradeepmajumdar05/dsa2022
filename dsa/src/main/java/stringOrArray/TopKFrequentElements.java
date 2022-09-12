package stringOrArray;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String [] args){
        int[] arr=topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        //int[] arr=topKFrequent(new int[]{1},1 );
        for(int i :arr){
            System.out.println(i);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map=new HashMap<>();
       for(int n:nums){
           map.put(n,map.get(n)==null?1:map.get(n)+1);
       }

       List<Integer>[] list=new List[nums.length+1];
       for(Integer key: map.keySet()){
           if(list[map.get(key)]==null){
               list[map.get(key)]=new ArrayList<>();
           }
           list[map.get(key)].add(key);
       }
        map=null;
       List<Integer> answer= new ArrayList<>();
       for(int i=list.length-1;i>=0;i--){
           if(k>0 && list[i]!=null){
               k=k-list[i].size();
               answer.addAll(list[i]);
           }else if (k==0){
               break;
           }
       }
        list=null;
        int[] output=new int[answer.size()];
       for(int i=0;i< answer.size();i++){
           output[i]= answer.get(i);
       }
        answer=null;
        return output;
    }
}
