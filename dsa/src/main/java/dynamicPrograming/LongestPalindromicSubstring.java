package dynamicPrograming;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));
    }
    static String max="";
    public static String longestPalindrome(String s) {
        for(int i=0 ; i<s.length() ; i++){
            //odd
            palindrome(i,i,s);
            //even
            palindrome(i,i+1,s);
        }
        return max;
    }
    public static void palindrome(int l, int r, String s){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 > max.length()){
                max=s.substring(l,r+1);
            }
            l--;
            r++;
        }
    }
}
