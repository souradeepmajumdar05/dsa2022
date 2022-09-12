package stringOrArray;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public static void main(String[] args){
        // System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
        //char[] ip=new char[]{'a','a','b','b','c','c','c'};
        //char[] ip=new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ip=new char[]{'a','a'};
        int ans=compress(ip);
        for(int i=0;i<ans;i++){
            System.out.println(ip[i]);
        }
    }
    public static int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        List<String> list= new ArrayList<>();
        int count =1;
        int start =0;
        for(int j=1;j<chars.length;j++){
            if(chars[j-1]==chars[j]){
                count++;
            }else{
                if(start!=0){
                    count++;
                }
                chars[start++]=chars[j-1];
                if(count>1)
                    chars[start++]= Character.valueOf((count + "").charAt(0));
                j=j+1;
                count =1;
            }
        }
        if(start!=0){
            count++;
        }
        chars[start++]=chars[chars.length-1];
        if(count>9){
            chars[start++]= Character.valueOf((count + "").charAt(0));
            chars[start++]= Character.valueOf((count + "").charAt(1));
        }
        else{
            chars[start++]= Character.valueOf((count + "").charAt(0));
        }


        return start;

    }
}
