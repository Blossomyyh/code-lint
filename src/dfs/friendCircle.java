package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class friendCircle {
    /**
     * Input:
     [[1,1,0],
     [1,1,0],
     [0,0,1]]
     Output: 2
     Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
     The 2nd student himself is in a friend circle. So return 2.
     */
    //todo: time O(n^2) space O(n)
    public static int findCircleNum(int[][] M) {
        int res = 0;
        int n = M.length;
        int[] visited = new int[n];//initial - (all == 0)
        for(int i = 0;i<M.length;i++){
            if (visited[i]==0) {
                visited[i] = 1;
                dfs(i, M, visited);
                res++;
            }
        }
        return res;
    }
    //todo: use visited--> its a reference of new int[n] -- so we do not need a private value
    public static void dfs(int i, int[][] M, int[] visited){
        for (int j = 0; j<M.length;j++){
            if (visited[j]!=1 && M[i][j]== 1){
                visited[j] = 1;
                dfs(j, M, visited);
            }
        }
    }
    //todo: bfs
    public int CircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue< Integer > queue = new LinkedList< >();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }


    //todo: union find
    //time O(n^3)

    /**
     * We make use of a
     parent array of size
     N. We traverse over all the nodes of the graph. For every node traversed,
     we traverse over all the nodes directly connected to it and assign them to a single group which is represented by their
     parent node. This process is called forming a
     union. Every group has a single
     parent node, whose own parent is given by -1;

     At the end, we find the number of groups, or the number of parent nodes. Such nodes have their parents indicated by a
     -1
     -1. This gives us the required count.
     * @param parent
     * @param i
     * @return
     */



    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int unionfindCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    public static void main (String args[]){
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        findCircleNum(M);
    }
}
