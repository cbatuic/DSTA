
package Graph;
import java.util.Scanner;

public class Solution {
        public static void main(String args[]) 
    {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Represent_Graph_TwoD_Array graph;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
 
            graph = new Represent_Graph_TwoD_Array(v);
 
            System.out.println("Enter the edges: <to> <from>");
            while (count <= e) 
            {
                to = sc.nextInt();
                from = sc.nextInt();
 
                graph.makeEdge(to, from, 1);
                count++;
            }
 
            System.out.println("The two d array for the given graph is: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();
 
            for (int i = 1; i <= v; i++) 
            {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++) 
                    System.out.print(graph.getEdge(i, j) + " ");
                System.out.println();
            }
 
        }
        catch (Exception E) 
        {
            System.out.println("Something went wrong");
        }
        sc.close();
    }
}


 
class Represent_Graph_TwoD_Array 
{
    private final int vertices;
    private int[][] twoD_array;
 
    public Represent_Graph_TwoD_Array(int v) 
    {
        vertices = v;
        twoD_array = new int[vertices + 1][vertices + 1];
    }
 
    public void makeEdge(int to, int from, int edge) 
    {
        try 
        {
            twoD_array[to][from] = edge;
            //twoD_array[from][to] = edge;
            
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
    }
 
    public int getEdge(int to, int from) 
    {
        try 
        {
            return twoD_array[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
 

}
