package stringOrArray;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        //System.out.println(minWindow("aa","aa"));
    }
    public static String minWindow(String s, String t) {
        if(t.equals(""))
            return "";
        Map<Character,Integer> countT= new HashMap<>();
        Map<Character,Integer> window= new HashMap<>();
        for(char c:t.toCharArray()){
            countT.put(c,countT.get(c)==null?1:countT.get(c)+1);
        }
        int l=0, r=0, have=0, need=countT.size() ,resLen=Integer.MAX_VALUE;
        int[]res=new int[]{-1,-1};
        for(r=0 ; r<s.length() ; r++){
            char c=s.charAt(r);
            window.put(c, window.get(c)==null ? 1 : window.get(c)+1);
            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))){
                have++;
            }
            while(have==need){
                if(resLen>(r-l+1)){
                    resLen= r-l+1;
                    res=new int[]{l,r};
                }
                c=s.charAt(l);
                window.put(c,window.get(c)-1);
                if(countT.containsKey(c) && countT.get(c)>window.get(c)){
                    have--;
                }
                l++;
            }
        }
        l=res[0];
        r=res[1];
        return resLen!=Integer.MAX_VALUE?s.substring(l,r+1):"";
    }

    //below code works
    public static String minWindowWorkingCode(String s, String t) {
        if(t.equals("")){
            return "";
        }
        Map<Character,Integer> countT =new HashMap<>();
        Map<Character,Integer> window =new HashMap<>();
        for(Character c: t.toCharArray()){
            countT.put(c,countT.get(c)==null ? 1 : countT.get(c)+1);
        }
        int have =0 ,need=countT.size();
        int[] res=new int[]{-1,-1};
        int resLen=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        for(r=0 ; r<s.length() ; r++){
            char c =s.charAt(r);
            window.put(c,window.get(c)==null ? 1 : window.get(c)+1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }
            while(have==need){
                //update your result
                if((r-l+1)<resLen){
                    res=new int[]{l,r};
                    resLen=r-l+1;
                }
                //pop from left
                window.put(s.charAt(l), window.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have--;
                }
                l++;
            }

        }
        l=res[0];
        r=res[1];
        return resLen!=Integer.MAX_VALUE? s.substring(l,r+1):"";
    }
}
