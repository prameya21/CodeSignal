import java.util.*;

public class CalculateBasins
{
    /*
    A group of farmers has some elevation data that we are going to use to help them understand how rainfall flows over their farmland. We represent the farmland as a 2D array of altitudes, the grid, and use the following model, based on the fact that water flows downhill:

    If a cell's four neighboring cells all have altitudes not lower that its own, this cell is a sink in which water collects.
    Otherwise, water will flow into the neighboring cell with the lowest altitude. If a cell is not a sink, you can assume it has a unique lowest neighbor and that this neighbor will be lower than the cell.
    Cells that drain into the same sink, directly or indirectly, are part of the same basin.
    Given an n × n grid of elevations, your goal is to partition the map into basins and output the sizes of the basins, in descending order.

    Example

    For

    grid = [[1, 5, 2],
            [2, 4, 7],
            [3, 6, 9]]
    the output should be
    calculateBasins(grid) = [7, 2].

    The two basins in this map, labeled as As and Bs, are:

      A A B
      A A B
      A A A
    The size of the basin labeled as As is 7 cells and the size of the basin labeled as Bs is 2 cells. The A basin drains into the sink with an altitude of 1 located at grid[0][0] and the B basin drains into the sink with an altitude of 2 located at grid[0][2].

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.integer grid

    A 2D array representing a map in which each cell has an altitude.

    Guaranteed constraints:
    1 ≤ grid.length ≤ 200,
    grid[i].length = grid.length,
    0 ≤ grid[i][j] ≤ 104.

    [output] array.integer

    An array containing the size of each basin in the grid.
     */

    public int find(int[] roots, int i)
    {
        if(roots[i]!=i)
            roots[i]=find(roots,roots[i]);
        return roots[i];
    }

    public void union(int[] roots, int i, int j)
    {
        int irep=find(roots,i);
        int jrep=find(roots,j);
        roots[jrep]=irep;
    }
    public int[] calculateBasins(int[][] grid)
    {
        int r=grid.length,c=grid[0].length;
        int[] roots=new int[r*c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int idx=i*c+j;
                roots[idx]=idx;//grid[i][j];
            }
        }



        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {

                int min=Integer.MAX_VALUE;
                int idx=0;

                if(i-1>=0 && grid[i][j]>grid[i-1][j] && min>grid[i-1][j])
                {
                    min=grid[i-1][j];
                    idx=(i-1)*c+j;
                }
                if(i+1<r && grid[i][j]>grid[i+1][j] && min>grid[i+1][j])
                {
                    min=grid[i+1][j];
                    idx=(i+1)*c+j;
                }
                if(j-1>=0 && grid[i][j]>grid[i][j-1] && min>grid[i][j-1])
                {
                    min=grid[i][j-1];
                    idx=i*c+j-1;
                }
                if(j+1<c && grid[i][j]>grid[i][j+1] && min>grid[i][j+1])
                {
                    min=grid[i][j+1];
                    idx=i*c+j+1;
                }
                if(min==Integer.MAX_VALUE || min>=grid[i][j])
                    continue;
                union(roots,idx,i*c+j);
            }
        }

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int key=find(roots,i*c+j);
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }

        List<Integer> result=new ArrayList<>(map.values());
        Collections.sort(result,Collections.reverseOrder());
        int[] ret=new int[result.size()];
        int idx=0;
        for(int i:result)
            ret[idx++]=i;
        return ret;
    }



    public static void main(String[] args)
    {
        CalculateBasins obj=new CalculateBasins();
        int[] ret=obj.calculateBasins(new int[][]{{1,5,2},{2,4,7},{3,6,9}});

        for(int i:ret)
            System.out.println(i);
    }
}
