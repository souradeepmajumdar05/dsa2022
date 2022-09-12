package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequence {
    public static void main(String []args){
        //System.out.println(minDistance("horse","ros"));
        System.out.println(numDistinct("rabbbit","rabbit"));
    }
    static String s;
    static String t;
    static Map<String,Integer> map =  new HashMap<String,Integer>();
    public static int numDistinct(String s, String t) {
        DistinctSubsequence.s=s;
        DistinctSubsequence.t=t;
        return dfs(0,0);
    }
    public static int dfs(int i, int j){
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        if(map.get(i+":"+j) != null)
            return map.get(i+":"+j);
        if(s.charAt(i)==t.charAt(j))
            map.put(i+":"+j,dfs(i+1,j+1)+dfs(i+1,j));
        else
            map.put(i+":"+j,dfs(i+1,j));
        return map.get(i+":"+j);
    }
}
