import java.util.*;
public class ClimbingStairs
{
    /*
    You need to climb a staircase that has n steps, and you decide to get some extra exercise by jumping up the steps. You can cover at most k steps in a single jump. Return all the possible sequences of jumps that you could take to climb the staircase, sorted.

    Example

    For n = 4 and k = 2, the output should be

    climbingStaircase(n, k) =
    [[1, 1, 1, 1],
     [1, 1, 2],
     [1, 2, 1],
     [2, 1, 1],
     [2, 2]]
    There are 4 steps in the staircase, and you can jump up 2 or fewer steps at a time. There are 5 potential sequences in which you jump up the stairs either 2 or 1 at a time.
     */

    public int[][] climbingStaircase(int n, int k)
    {
        List<List<Integer>> result=new ArrayList<>();
        helper(n,k,new ArrayList<>(), result);
        System.out.println(result);
        int[][] ret=new int[result.size()][];
        for(int i=0;i<ret.length;i++)
        {
            ret[i]=new int[result.get(i).size()];
            for(int j=0;j<ret[i].length;j++)
                ret[i][j]=result.get(i).get(j);
        }
        return ret;
    }

    public void helper(int n, int k,List<Integer> temp, List<List<Integer>> result)
    {
        if(n<0)
            return;
        if(0==n)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=1;i<=k;i++)
        {
            temp.add(i);
            helper(n-i,k,temp,result);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args)
    {
        ClimbingStairs obj=new ClimbingStairs();
        System.out.println(obj.climbingStaircase(4,2));
    }

}
