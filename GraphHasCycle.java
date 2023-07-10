import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Approach: 
 
1. Create a matrix of size n*n where every element is 0 representing there is no edge in the graph.
2. Now, for every edge of the graph between the vertices i and j set mat[i][j] = 1.
3. After the adjacency matrix has been created and filled, call the recursive function for the source i.e. vertex 0 that will recursively call the same function for all the vertices adjacent to it.
4. Also, keep an array to keep track of the visited vertices i.e. visited[i] = true represents that vertex i has been visited before and the DFS function for some already visited node need not be called.
5. If node has already been visited, increment the counter.
*/

public class Solution {

    // cycle counter
    static int cycle = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int graph[][] = new int[V][V];
        boolean[] visited = new boolean[V];
        while(E-->0){
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst]=1;
        }
        
        int result = hasCycle(V,E,graph,visited);
        if(result > 0) System.out.println("The graph has " + result + " cycle/s.");
        else System.out.println("The graph doesn't have any cycle.");
    }
    
    public static int hasCycle(int V, int E, int graph[][], boolean[] visited){
        dfs(0, visited, graph);
        return cycle;
    }
    
    static void dfs(int start, boolean[] visited, int graph[][])
    {
        // Set current node as visited
        visited[start] = true;
 
        // For every node of the graph
        for (int i = 0; i < graph[start].length; i++) {
            // If some node is adjacent to the current node
            if (graph[start][i] == 1)  {
                // cycle detected
                if (visited[i])  cycle++;
                // traverse node that has not already been visited
                if (!visited[i]) dfs(i, visited, graph);
            }
        }
    }    
}
