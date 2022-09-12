package dynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static void main(String[] args){
        System.out.println(wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }
    static Map<String,Boolean> memo=new HashMap<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s))
            return memo.get(s);
        if(s.equals(""))
            return true;
        for(String word:wordDict){
            if(s.indexOf(word)==0){
                String suffix=s.substring(word.length());
                if(wordBreak(suffix,wordDict)){
                    memo.put(suffix,true);
                    return true;
                }
            }
        }
        memo.put(s,false);
        return false;
    }
}
