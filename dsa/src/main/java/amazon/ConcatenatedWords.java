package amazon;

import java.util.*;

public class ConcatenatedWords {
    Set<String> set;
    boolean isPossible(String str)
    {
        boolean dp[]=new boolean[str.length()+1];
        dp[0]=true;
        for(int i=0;i<=str.length();i++)
        {
            int j=i-1;
            while(j>=0)
            {
                if(dp[j]&&set.contains(str.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
                j--;
            }
        }
        // System.out.println("Str: "+str+"  "+dp[str.length()]);
        return dp[str.length()];
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        set=new HashSet<>();
        List<String>res=new ArrayList<>();
        Arrays.sort(words,(a, b) -> a.length()-b.length());

        for(String word : words)
        {
            if(set.size()>0 && isPossible(word))
                res.add(word);
            set.add(word);
        }
        return res;

    }
}
