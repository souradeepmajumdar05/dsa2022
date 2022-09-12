package stringOrArray;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args){
        //List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
       // List<List<String>> result = groupAnagrams(new String[]{"","b"});
        List<List<String>> result = groupAnagrams(new String[]{"tea","and","ace","ad","eat","dans"});
        for(List<String> r:result){
            for (String s : r){
                System.out.print(s+" ,");
            }
            System.out.println("");
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] arrs=s.toCharArray();
            Arrays.sort(arrs);
            String sSorted=String.valueOf(arrs);
            if(map.containsKey(sSorted)){
                List<String> temp=map.get(sSorted);
                temp.add(s);
                map.put(sSorted,temp);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(sSorted,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;

    }
    public static List<List<String>> groupAnagramsWorkingButTimeExceeded(String[] strs) {
        List<List<String>> result=new ArrayList<List<String>>();
        Map<Character,Integer> map = null;
        boolean[] visited = new boolean[strs.length];
        List<String> curList=null;
        for(int i=0 ; i<strs.length; i++){
            if(!visited[i]){
                visited[i]=true;
                curList=new ArrayList<>();
                curList.add(strs[i]);

                map=new HashMap<>();
                if(strs[i].length()==0){
                    map.put(null,1);
                }
                for(int j=0;j<strs[i].length();j++){

                    Character c=strs[i].charAt(j);
                    map.put(c,map.get(c)==null?1:map.get(c)+1);
                }
                for(int k=i+1 ; k<strs.length; k++){
                    if(!visited[k]){
                        Map<Character,Integer> localMap = new HashMap<>();
                        if(strs[k].length()==0){
                            localMap.put(null,1);
                        }
                        for(int j=0;j<strs[k].length();j++){
                            Character c=strs[k].charAt(j);
                            localMap.put(c,localMap.get(c)==null?1:localMap.get(c)+1);
                        }
                        int a=0;
                        for(Character c:map.keySet()){
                            if(localMap.get(c)!=null&&localMap.get(c).equals(map.get(c))){
                                a++;
                            }
                        }
                        if(a==map.size() && a==localMap.size()){
                            curList.add(strs[k]);
                            visited[k]=true;
                        }
                    }
                }
                result.add(curList);
            }
        }
        return result;
    }
}
