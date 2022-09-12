package amazon.courseschedule;

import java.util.*;

public class CourseScheduleIV {
    List<Integer>[] adj; // adjcency list
    boolean[][] isReachable;

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        adj = new List[n];
        isReachable = new boolean[n][n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : prerequisites)
            adj[edge[0]].add(edge[1]);

        for (int i = 0; i < n; i++)
            dfs(i, i);

        List<Boolean> res = new ArrayList<>();

        for (int[] query : queries)
            res.add(isReachable[query[0]][query[1]]);

        return res;
    }

    void dfs(int o, int v)
    {
        isReachable[o][v] = true;
        for (int w : adj[v])
        {
            if (isReachable[o][w])
                continue;
            dfs(o, w);
        }
    }
}
