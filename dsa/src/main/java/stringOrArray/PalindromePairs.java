package stringOrArray;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
    public static void main(String[] args){
        List<List<Integer>> answer= palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        for(int i=0 ; i<answer.size() ; i++){
            System.out.println(answer.get(i).get(0)+" : "+answer.get(i).get(1));
        }
    }
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                String first =words[i]+words[j];

                if(isPalindrome(first)){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    answer.add(list);
                }
                String second =words[j]+words[i];
                if(isPalindrome(second)){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(j);
                    list.add(i);
                    answer.add(list);
                }
            }
        }
        return answer;
    }
    public static boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
