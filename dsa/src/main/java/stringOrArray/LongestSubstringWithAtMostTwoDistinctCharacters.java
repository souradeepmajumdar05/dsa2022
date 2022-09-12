package stringOrArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args){
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("eceba"));
    }
    //this answers feels more intutitve
    public static int lengthOfLongestSubstring(String s) {
        int count =0,i=0,j=0;
            //character ,occurrences
        Map<Character,Integer> dp = new HashMap<>();
        while(j<s.length()){
            if(dp.size()<=2){
                Integer occurrences=dp.get(s.charAt(j));
                dp.put(s.charAt(j), occurrences==null?1:occurrences+1);
                j++;
            }
            while(dp.size()>2){
                int occurrences = dp.get(s.charAt(i));
                occurrences=occurrences-1;
                if(occurrences==0){
                    dp.remove(s.charAt(i));
                }else{
                    dp.put(s.charAt(i),occurrences);
                }
                i++;
            }
            count= count<(j-i)?(j-i):count;
        }
        return count;
    }



























    public static int lengthOfLongestSubstringWorkingCode(String s) {
        int output = 0;
        int l = 0, r = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()) {
            if(map.size() <= 2) {
                char c = s.charAt(r);
                map.put(c, r);
                r++;
            }
            if(map.size() > 2) {
                int left = s.length();
                for(int i : map.values()) {
                    left = Math.min(left, i);
                }
                char c = s.charAt(left);
                map.remove(c);
                l = left + 1;
            }
            output = Math.max(output, r - l);
        }
        return output;
    }
}
