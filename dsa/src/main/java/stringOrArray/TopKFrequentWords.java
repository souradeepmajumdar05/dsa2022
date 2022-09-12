package stringOrArray;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String [] args){
        List<String> ans=topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.get(s)==null?1:map.get(s)+1);
        }
        List<String> ans= new ArrayList<>();
        TreeMap<Integer,List<String>> tmap=new TreeMap<>();
        for(String w:map.keySet()){
            if(tmap.get(map.get(w))==null){
                tmap.put(map.get(w),new ArrayList<>());
            }
            tmap.get(map.get(w)).add(w);
        }
        List<Integer>keys=new ArrayList<>(tmap.keySet());
        for(int i=keys.size()-1;i>=0;i--){
            if(k>0){
                ans.addAll(tmap.get(keys.get(i)));
                k=k-tmap.get(keys.get(i)).size();
            }
        }
        Collections.sort(ans);

        return ans;
    }
}
