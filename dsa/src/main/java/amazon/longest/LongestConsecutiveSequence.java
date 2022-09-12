package amazon.longest;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums)
    {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int curentStreak = 1 ;
        int longestStreak = 1;
        for(int i = 1; i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                if(nums[i]==nums[i-1]+1)
                {
                    curentStreak++;
                }
                else
                {
                    longestStreak = Math.max(longestStreak,curentStreak);
                    curentStreak=1;
                }
            }
        }
        return Math.max(longestStreak,curentStreak);
    }
}
