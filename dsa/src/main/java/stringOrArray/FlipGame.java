package stringOrArray;

import java.util.ArrayList;
import java.util.List;

/**
 * ["++-+++-+++-+",
 *  "-+++++-+++-+",
 *  "---+++-+---+",
 *  "---+++---+-+",
 *  "---+---+++-+",
 *  "-----+-+++-+"]
 *
 *  "---+++-+++-+"
 *
 * ["---+++-+---+",
 *  "---+++---+-+",
 *  "---+---+++-+",
 *  "-----+-+++-+"]
 *
 *
 * */
public class FlipGame {
    public static void main(String[] args){
        //List<String> result=generatePossibleNextMoves("++++");
        List<String> result=generatePossibleNextMoves("---+++-+++-+");
        for(String s: result){
            System.out.println(s);
        }
    }

    public static List<String> generatePossibleNextMovesw (String s) {
        // write your code here
        List list = new ArrayList();
        for (int i = -1; (i = s.indexOf ("++", i + 1)) >= 0;) {
            list.add (s.substring (0, i) + "--" + s.substring (i + 2));
        }
        return list;
    }
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                char[] arr=s.toCharArray();
                if('+'==s.charAt(i)){
                    arr[i]='-';
                    arr[i-1]='-';
                }
//                else{
//                    arr[i]='+';
//                    arr[i-1]='+';
//                }
                list.add(new String(arr));
            }
        }
        return list;
    }
}
