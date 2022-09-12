package stringOrArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles {
    public static void main(String[] args){
        //String[] answer=reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        //String[] answer=reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        String[] answer=reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});
        for (String s:answer){
            System.out.println(s);
        }
    }
    public static  String[] reorderLogFiles(String[] logs) {
        String[] answer = new String[logs.length];
        List<String> numeric= new ArrayList<>();
        List<String> alpha= new ArrayList<>();
        for (int i=0 ;i<logs.length;i++){
            String []row=logs[i].split(" ");
            if(row.length>1 && isAlpha(row[1])){
                numeric.add(logs[i]);
            }else{
                alpha.add(logs[i]);
            }
        }
        Collections.sort(alpha, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")))==0){
                    return o1.compareTo(o2);
                }
                return o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
            }
        });
        int i=0;
        for(int j=0;j<alpha.size();j++){
            answer[i++]=alpha.get(j);
        }
        for(int j=0;j<numeric.size();j++){
            answer[i++]=numeric.get(j);
        }
        return answer;
    }

    private static boolean isAlpha(String s) {
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9')){
                return false;
            }
        }
        return true;
    }
}
