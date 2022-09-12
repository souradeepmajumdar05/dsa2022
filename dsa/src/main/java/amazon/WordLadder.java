package amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if(!wordList.contains(endWord))
        {
            return 0;
        }
        Set<String> beginning = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        beginning.add(beginWord);
        end.add(endWord);
        return bfs(beginning, end,new HashSet<String>(wordList), 1);
    }
    public int bfs(Set<String> beginning,Set<String> end,Set<String> dict,int count)
    {
        if(beginning.isEmpty()||end.isEmpty())
        {
            return 0;
        }
        count++;
        dict.removeAll(beginning);
        Set<String> next = new HashSet<String>();
        for(String str : beginning)
        {
            char[] arr = str.toCharArray();
            for(int i=0 ; i<arr.length ; i++)
            {
                char c = arr[i];
                for(char ch = 'a' ; ch <= 'z' ; ch++)
                {
                    arr[i]=ch;
                    String s = new String(arr);
                    if(!dict.contains(s))
                    {
                        continue;
                    }
                    if(end.contains(s))
                    {
                        return count;
                    }
                    next.add(s);
                }
                arr[i]=c;
            }
        }
        return next.size()>end.size()?bfs(end,next,dict,count):bfs(next,end,dict,count);
    }
}
