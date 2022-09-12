package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.*;
import java.util.Set;
import java.util.*;
public class Test{

    public static void main(String []args){
        findLargest("1100");
    }
    public static String findLargest(String str) {
        String[] splits = str.split("");
        Set<String> set = new LinkedHashSet<String>();
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals("0")) {
                continue;
            }
            int zeros = 0;
            int ones = 0;
            StringBuilder sb = new StringBuilder("");
            for (int j = i; j < splits.length; j++) {
                if (splits[j].equals("0")) {
                    zeros++;
                } else {
                    ones++;
                }
                sb.append(splits[j]);
                if (zeros == ones && ones >= zeros) {
                    set.add(sb.toString());
                    j = i +1; // RESET THE INDEX ELEMENT TO SKIP THE SUBSTRING FROM CONSIDERATION
                    break;  // BREAK FROM THE LOOP
                }
            }
        }
        set.remove(str);

        List<String> list = new ArrayList<String>(set);
        System.out.println(list);

        return null;
    }
}