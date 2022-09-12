package stringOrArray;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstringMy(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int count =0;
        int i=0;
        int j=1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while(i<s.length() && j<s.length()){
            if(s.charAt(i)!=s.charAt(j) && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                count=count<(j-i+1)?(j-i+1):count;
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
                j= i>=j ? i+1 : j;
            }
        }
        return count==0?1:count;
    }
    public static int lengthOfLongestSubstring(String s) {
        int l=0;
        Set<Character> set = new HashSet<>();
        int count =0;
        for(int r=0; r<s.length() ; r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            count=Math.max(count,r-l+1);
        }
        return count;
    }
}
