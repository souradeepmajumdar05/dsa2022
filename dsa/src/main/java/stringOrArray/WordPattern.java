package stringOrArray;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args){
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        if(pattern.length()!=arr.length){
            return false;
        }
        Map<Character,String> ps=new HashMap<Character,String>();
        Map<String,Character> sp=new HashMap<String,Character>();
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if((ps.get(c)!=null && sp.get(arr[i])==null)||ps.get(c)==null && sp.get(arr[i])!=null){
                return false;
            }
            if(ps.get(c)!=null && sp.get(arr[i])!=null) {
                if (!(ps.get(c).equals(arr[i]) && sp.get(arr[i]) == c)) {
                    return false;
                }
            }else{
                    ps.put(c,arr[i]) ;
                    sp.put(arr[i],c);
            }
        }
        return true;
    }
}
