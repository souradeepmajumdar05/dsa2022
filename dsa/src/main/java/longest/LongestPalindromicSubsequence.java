package longest;

public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public static int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length, max = 0;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for(int i = j-1; i >= 0; i--)
            {
                int len = dp[i];
                if(c[i] == c[j])
                {
                    dp[i] = 2 + max;
                }
                max = Math.max(max, len);
            }
        }
        for(int len: dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}
