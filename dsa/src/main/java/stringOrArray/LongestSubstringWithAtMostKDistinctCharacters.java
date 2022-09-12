package stringOrArray;

import java.util.HashMap;
import java.util.Map;

//https://www.lintcode.com/problem/386/description
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args){
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstringKDistinct("eceba",3));
    }
    //this answers feels more intutitve
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count =0,i=0,j=0;
        //character ,occurrences
        Map<Character,Integer> dp = new HashMap<>();
        while(j<s.length()){
            if(dp.size()<=k){
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
    public static int lengthOfLongestSubstringKDistinctWorkingCode(String s, int k) {

        if (s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0, cnt = 0;
        int charSet[] = new int[256];
        int ans = 0;

        while (right < s.length()) {
            if (charSet[s.charAt(right)] == 0) {
                cnt++;
            }
            charSet[s.charAt(right)]++;
            right++;
            while (cnt > k) {
                charSet[s.charAt(left)]--;
                if (charSet[s.charAt(left)] == 0) {
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
