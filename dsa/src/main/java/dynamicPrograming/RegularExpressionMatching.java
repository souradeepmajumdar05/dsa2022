package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;


//need to do this again
public class RegularExpressionMatching {
    public static void main(String[] args){
        System.out.println(isMatch("aa","a"));
    }
    static String s;
    static String p;
    static Map<String,Boolean> memo = new HashMap<String,Boolean>();
    public static boolean isMatch(String s, String p) {
        RegularExpressionMatching.s=s;
        RegularExpressionMatching.p=p;
        return dfs(0,0);
    }
    public static boolean dfs(int i, int j){
        if(memo.get(i+"+"+j)!=null)
            return memo.get(i+"+"+j);

        if (i >= s.length() && j >= p.length())
            return true;

        if (j>=p.length())
            return false;

        Boolean match= i< s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        if((j+1) < p.length() && p.charAt(j+1)=='*'){
                               //dont use *       //if match then use *
            memo.put(i+"+"+j , (dfs(i, j+2) || (match && dfs(i+1,j))));
            return memo.get(i+"+"+j);
        }

        if(match){
            memo.put(i+"+"+j , dfs(i+1, j+1));
            return memo.get(i+"+"+j);
        }

        memo.put(i+"+"+j , false);

        return false;
    }
}
