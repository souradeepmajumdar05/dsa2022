package amazon.maximum;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0)
        {
            return 0;
        }
        int n = A.length;
        int minSum = 0;
        int maxSum = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
        {
            sum += A[i];
            minSum += A[i];
            maxSum += A[i];
            if (minSum < min)
                min = minSum;

            if (maxSum > max)
                max = maxSum;

            if (minSum > 0)
                minSum = 0;

            if (maxSum < 0)
                maxSum = 0;
        }

        if (max < 0)
            return max;

        return Math.max(max, sum - min);
    }
}
