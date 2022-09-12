package dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    public static void main(String [] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        Map<Integer,Integer> dp =new HashMap<Integer,Integer>();
        dp.put(1,1);
        for(int num=2 ; num<n+1 ; num++){
            dp.put(num, n==num? 0 : num);
            for(int i= 1 ; i<num; i++){
                int val = dp.get(i) * dp.get(num-i);
                dp.put(num,Math.max(dp.get(num),val));
            }
        }
        return dp.get(n);

    }

}
