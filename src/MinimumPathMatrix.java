import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumPathMatrix
{
    int dfs_ans;
    /*
    Given a m-by-n matrix containing positive numbers, you start from top left and travel towards bottom right.
    You can move in either up, down, left, or right directions. When moving from a higher number to lower or equal number, the cost is 0.
    When moving from a lower number to a higher number, the cost is the absolute difference.
    Find and return the minimum cost from top left to bottom right of the matrix.


        1 9 5 9 5
        1 4 1 1 1
        1 1 1 8 1
        1 9 9 9 1
        1 9 9 9 1
        1 1 1 9 1

        1 9 5
        1 4 1
        1 1 9


     */

    public int minPath(int[][] matrix)
    {
        if(matrix==null || matrix.length==0)
            return 0;
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] i, int[] j)
            {
                return i[2]-j[2];
            }
        });
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        visited[0][0]=true;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            if(curr[0]==matrix.length-1 && curr[1]==matrix[0].length-1)
                return curr[2];
            for(int[] d:dirs)
            {
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(nr<0 || nr>=matrix.length || nc<0 || nc>=matrix[0].length || visited[nr][nc])
                    continue;
                int cost=curr[2];
                if(matrix[nr][nc]>matrix[curr[0]][curr[1]])
                    cost+=(matrix[nr][nc]-matrix[curr[0]][curr[1]]);

                pq.offer(new int[]{nr,nc,cost});
                visited[nr][nc]=true;
            }
        }
        return -1;
    }


    public int minPath2(int[][] grid)
    {
        if(grid==null || grid.length==0)
            return 0;
        dfs_ans=Integer.MAX_VALUE;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        dfs(grid,visited,0,0, 0,Integer.MAX_VALUE);
        return dfs_ans;
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int cost,int prev)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j])
            return;

        if(prev<grid[i][j])
            cost+=Math.abs(prev-grid[i][j]);
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            dfs_ans=Math.min(dfs_ans,cost);
            return;
        }

        visited[i][j]=true;
        dfs(grid,visited,i+1,j,cost,grid[i][j]);
        dfs(grid,visited,i-1,j,cost,grid[i][j]);
        dfs(grid,visited,i,j+1,cost,grid[i][j]);
        dfs(grid,visited,i,j-1,cost,grid[i][j]);
        visited[i][j]=false;
    }




    public static void main(String[] args)
    {
        MinimumPathMatrix obj=new MinimumPathMatrix();
        System.out.println(obj.minPath(new int[][]{{1,9,5,5},{1,4,1,9},{1,1,8,1}}));
        System.out.println(obj.minPath(new int[][]{{1,9,5},{1,4,1},{1,1,9}}));
        System.out.println(obj.minPath(new int[][]{{1, 9, 5, 9, 5},{1, 4, 1, 1, 1},{1, 1, 1, 8, 1},{1, 9, 9, 9, 1},{1, 9, 9, 9, 1},{1, 1, 1, 9, 1,}}));


        //System.out.println(obj.minPath2(new int[][]{{1,9,5,5},{1,4,1,9},{1,1,8,1}}));
        //System.out.println(obj.minPath2(new int[][]{{1,9,5},{1,4,1},{1,1,9}}));
        System.out.println(obj.minPath2(new int[][]{{1, 9, 5, 9, 5},{1, 4, 1, 1, 1},{1, 1, 1, 8, 1},{1, 9, 9, 9, 1},{1, 9, 9, 9, 1},{1, 1, 1, 9, 1,}}));
    }
}
