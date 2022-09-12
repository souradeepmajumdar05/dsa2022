package amazon;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++)
        {
            int temp[] = Arrays.copyOf(distance, n);
            boolean changed = false;
            for (int[] edge : flights)
            {
                if (distance[edge[0]] == Integer.MAX_VALUE)
                {
                    continue;
                }

                if (temp[edge[1]] > distance[edge[0]] + edge[2])
                {
                    temp[edge[1]] = distance[edge[0]] + edge[2];
                    changed = true;
                }
            }
            distance = temp;
            if (!changed)
            {
                return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
