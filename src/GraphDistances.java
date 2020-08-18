import java.util.*;
public class GraphDistances
{
    /*
    You have a strongly connected directed graph that has positive weights in the adjacency matrix g. The graph is represented as a square matrix, where g[i][j] is the weight of the edge (i, j), or -1 if there is no such edge.

    Given g and the index of a start vertex s, find the minimal distances between the start vertex s and each of the vertices of the graph.

    Example

    For

    g = [[-1, 3, 2],
         [2, -1, 0],
         [-1, 0, -1]]
    and s = 0, the output should be
    graphDistances(g, s) = [0, 2, 2].

    Example

    The distance from the start vertex 0 to itself is 0.
    The distance from the start vertex 0 to vertex 1 is 2 + 0 = 2.
    The distance from the start vertex 0 to vertex 2 is 2.
     */

    public int[] graphDistances(int[][] g, int s)
    {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[0].length;j++)
            {
                if(g[i][j]==-1)
                    continue;
                map.putIfAbsent(i,new ArrayList<>());
                map.get(i).add(new int[]{j,g[i][j]});
            }
        }
        int[] ret=new int[g.length];
        Arrays.fill(ret,Integer.MAX_VALUE);
        ret[s]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b)
            {
                return a[1]-b[1];
            }
        });
        pq.offer(new int[]{s,0});
        boolean[] visited=new boolean[g.length];

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int n=curr[0], cost=curr[1];
            ret[n]=Math.min(ret[n],cost);
            visited[n]=true;
            if(!map.containsKey(n))
                    continue;
            for(int[] nxt:map.get(n))
            {
                if(visited[nxt[0]])
                    continue;
                pq.offer(new int[]{nxt[0],cost+nxt[1]});
            }
        }
        return ret;
    }

    public static void main(String[] args)
    {
        GraphDistances obj=new GraphDistances();
        int[][] g={{-1,3,2},{2,-1,0},{-1,0,-1}};
        int[] ret=obj.graphDistances(g,0);
        for(int i:ret)
            System.out.println(i);
    }
}
