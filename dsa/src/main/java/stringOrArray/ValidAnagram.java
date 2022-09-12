package stringOrArray;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] arr= s.toCharArray();
        Arrays.sort(arr);
        s=new String(arr);
        arr= t.toCharArray();
        Arrays.sort(arr);
        t=new String(arr);
        return t.equals(s);
    }

}
