package stringOrArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
    public static void main(String[] args){
       // System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
        System.out.println(mostCommonWord("Bob. hIt, baLl",new String[]{"bob", "hit"}));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.replace("!"," ");
        paragraph=paragraph.replace("?"," ");
        paragraph=paragraph.replace("'"," ");
        paragraph=paragraph.replace(","," ");
        paragraph=paragraph.replace(";"," ");
        paragraph=paragraph.replace("."," ");
        String[] pararr=paragraph.split(" ");
        List<String> bannedList= Arrays.asList(banned);
        Map<String,Integer> count = new HashMap<>();
        for(String s:pararr){
            String temp=s.toLowerCase();
            if(!bannedList.contains(temp)&&!temp.equals("")){
                count.put(temp,count.get(temp)==null?1:count.get(temp)+1);
            }
        }
        String answer="";
        Integer max=Integer.MIN_VALUE;
        for(String s:count.keySet()){
            if(max<count.get(s)){
                max=count.get(s);
                answer=s;
            }
        }
        return answer;
    }
}

