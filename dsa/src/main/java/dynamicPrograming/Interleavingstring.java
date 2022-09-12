package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class Interleavingstring {
    public static void main(String [] args){
        System.out.println(isInterleave("","","a"));
    }
    static String s1=null;
    static String s2=null;
    static String s3=null;
    static Map<String,Boolean> memo= new HashMap<String,Boolean>();
    public static boolean isInterleave(String s1, String s2, String s3) {
        Interleavingstring.s1=s1;
        Interleavingstring.s2=s2;
        Interleavingstring.s3=s3;
        return dfs(0,0);
    }
    public static boolean  dfs(int i, int j){
        if(i==s1.length() && j == s2.length()  && s1.length()+s2.length()==s3.length())
            return true;
        if(memo.get(i+"+"+j)!=null)
            return memo.get(i+"+"+j);
        if(i<s1.length() && i+j < s3.length() && s1.charAt(i)==s3.charAt(i+j) && dfs(i+1,j))
            return true;
        if(j<s2.length() && i+j < s3.length() && s2.charAt(j)==s3.charAt(i+j) && dfs(i,j+1))
            return true;
        memo.put(i+"+"+j,false);
        return false;
    }
}
