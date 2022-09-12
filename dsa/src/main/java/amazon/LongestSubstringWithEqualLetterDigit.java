package amazon;

import java.util.HashMap;

public class LongestSubstringWithEqualLetterDigit {
    private static String longestSubstring (String s) {
        if(s==null || s.length()==0)
            return "";
        HashMap<Integer,Integer> map = new HashMap<>();
        int sumSoFar =0;
        int endIndex=-1;
        map.put(0,  -1);
        int startIndex = Integer.MIN_VALUE;

        for(int i = 0;i< s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                sumSoFar--;
            }
            else
            {
                sumSoFar++;
            }
            if(map.containsKey(sumSoFar))
            {
                if(i-map.get(sumSoFar)>startIndex)
                {
                    startIndex=i-map.get(sumSoFar);
                    endIndex=i+1;
                }
            }
            else
            {
                map.put(sumSoFar, i);
            }
        }
        return startIndex!=Integer.MIN_VALUE ? s.substring(endIndex-startIndex, endIndex): "";
    }

    public static void main(String[] args) {
        //String s="bcd1234ab34";
        String s="abcde123";
        System.out.println(longestSubstring(s)); //bcd1234ab3
    }
}
