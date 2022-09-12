package stringOrArray;

import java.util.Arrays;
import java.util.Comparator;

//greedy
public class LargestNumber {
    public static void main(String[] args){
        // System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        // System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] arr=new String[nums.length];
        for(int i=0; i< nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(String s:arr){
            sb.append(s);
        }
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
