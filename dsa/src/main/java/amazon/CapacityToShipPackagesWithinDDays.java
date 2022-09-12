package amazon;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D)
    {
        int left = 0, right = 0;
        for (int w : weights)
        {
            left = Math.max(w, left);
            right += w;
        }
        while (left < right)
        {
            int mid = (left + right) /2,
                    curr = 0,
                    days = 1;

            for (int w : weights)
            {
                if (curr + w > mid)
                {
                    curr = 0;
                    days++;
                }
                curr += w;
            }
            if (days > D)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
}
