package amazon;

import java.util.*;

public class ShortestPathinaGridwithObstaclesElimination {
    class Node {
        int r, c;
        int k;
        Node(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            Queue<Node> queue = new LinkedList<>();
            int m = grid.length;
            int n = grid[0].length;
            int[][] visited = new int[m][n];
            for(int[] a : visited)
                Arrays.fill(a, Integer.MAX_VALUE);
            visited[0][0] = 0;

            queue.add(new Node(0, 0, 0));
            int level = 0;
            int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
            while(! queue.isEmpty())
            {
                int size = queue.size();
                for(int i=0; i<size; i++)
                {
                    Node node = queue.poll();
                    if (node.r == m-1 && node.c == n-1)
                        return level;

                    for(int d=0; d<4; d++)
                    {
                        int r = node.r + dirs[d][0];
                        int c = node.c + dirs[d][1];

                        if (r<0 || r>=m || c<0 || c>=n || grid[r][c] == -1)
                            continue;

                        int newK = node.k + grid[r][c];

                        if (newK > k)
                            continue;

                        // continue if we have more optimal result
                        if (visited[r][c] <= newK)
                            continue;

                        visited[r][c] = newK;
                        queue.add(new Node(r,c,newK));
                    }
                }
                level++;
            }
            return -1;
        }
    }
}

class Solution {
    int[] dirs = { 0, 1, 0, -1, 0 };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 2)
            return m + n - 2; // if we can go by manhattan distance -> let's go

        boolean[][][] visited = new boolean[m][n][k + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] { 0, 0, k, 0 }); // row, column, k, dist
        visited[0][0][k] = true;

        while (!queue.isEmpty())
        {
            int[] top = queue.removeFirst();
            int row = top[0], column = top[1], curK = top[2], dist = top[3];
            if (row == m - 1 && column == n - 1){
                return dist; // Found the result
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + dirs[i], newColumn = column + dirs[i + 1];
                if (newRow < 0 || newRow == m || newColumn < 0 || newColumn == n){
                    continue; // skip out of bound cells!
                }

                int newK = curK;
                if(grid[newRow][newColumn] == 1){
                    newK--;
                }
                if (newK >= 0 && !visited[newRow][newColumn][newK]) {
                    visited[newRow][newColumn][newK] = true;
                    queue.addLast(new int[] { newRow, newColumn, newK, dist + 1 });
                }
            }
        }
        return -1; // Not found
    }
}
