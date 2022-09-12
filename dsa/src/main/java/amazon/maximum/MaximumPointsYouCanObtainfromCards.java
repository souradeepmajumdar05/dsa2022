package amazon.maximum;

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0,
                min = Integer.MAX_VALUE,
                n = cardPoints.length,
                len = n - k;   // transfer to min slidng window

        for (int l = 0, r = 0, tot = 0; r < n; r++)
        {
            sum += cardPoints[r];
            tot += cardPoints[r];

            if (r >= len)
                tot -= cardPoints[l++];

            if (r >= len - 1)
                min = Math.min(min, tot);
        }
        return sum - min;
    }
}
