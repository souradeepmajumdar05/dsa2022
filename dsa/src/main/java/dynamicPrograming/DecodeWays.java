package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args){
        System.out.println(numDecodings("226"));
    }

    static Map<String, Integer> map = new HashMap<>();
    public static int numDecodings(String s) {
        if(s.length()>0 && s.charAt(0)=='0')
            return 0;
        if(s.length() <= 1)
            return 1;
        if(map.get(s) != null) return map.get(s);
        int result = 0;
        if(Integer.parseInt(s.substring(0,2)) <=26 )
            result = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        else
            result = numDecodings(s.substring(1));
        map.put(s, result);
        return result;
    }

}
