package amazon.graph;

import java.util.HashMap;
//https://leetcode.com/problems/redundant-connection/
public class RedundantConnection {
    public static void main(String [] args){
        RedundantConnection redundantConnection = new RedundantConnection();
        int[] ans=redundantConnection.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}});
        for (int i:ans){
            System.out.println(i);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge: edges) {
            int parentX = unionFind.find(edge[0]);
            int parentY = unionFind.find(edge[1]);
            if (parentX == parentY) {
                return edge;
            }
            unionFind.union(edge[0], edge[1]);
        }
        return new int[] {};
    }
}

class UnionFind {
    private HashMap<Integer, Integer> parents = new HashMap<>();

    public UnionFind(int n) {
        for(int i = 1; i <= n; i++) {
            parents.put(i, i);
        }
    }

    public int find(int x) {
        if (parents.get(x) == x) {
            return x;
        }
        return find(parents.get(x));
    }

    public void union(int x, int y) {
        parents.put(find(x), parents.get(find(y)));
    }
}