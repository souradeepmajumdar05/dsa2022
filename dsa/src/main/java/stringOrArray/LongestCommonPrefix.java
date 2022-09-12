package stringOrArray;

public class LongestCommonPrefix {
    public static void main(String[] args){
       // System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
       // System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==1)
            return strs[0];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            for(String s:strs){
                if (i>s.length()-1 || s.charAt(i)!=strs[0].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
