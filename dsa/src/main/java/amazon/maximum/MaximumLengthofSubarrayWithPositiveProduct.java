package amazon.maximum;

public class MaximumLengthofSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int prod = 1;
        int neg = -1;
        int start = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++)
        {
            prod = Integer.compare(prod*nums[i], 0);
            if(prod == 0)
            {
                neg=-1;
                start=i+1;
                prod=1;
            }
            else if(prod > 0)
            {
                max = Math.max(max, i-start+1);
            }
            else
            {
                if(neg==-1)
                {
                    neg = i;
                }
                else if(i-neg>max)
                {
                    max = i - neg;
                }
            }
        }
        return max;
    }
}
