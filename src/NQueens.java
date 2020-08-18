import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens
{
    /*
    In chess, queens can move any number of squares vertically, horizontally, or diagonally. The n-queens puzzle is the problem of placing n queens on an n × n chessboard so that no two queens can attack each other.

    Given an integer n, print all possible distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the placement of the n queens,
    where the solutions are arrays that contain permutations of [1, 2, 3, .. n]. The number in the ith position of the results array indicates
    that the ith column queen is placed in the row with that number. In your solution, the board configurations should be returned in lexicographical order.

    Example

    For n = 1, the output should be
    nQueens(n) = [[1]];

    For n = 4, the output should be

    nQueens(n) = [[2, 4, 1, 3],
                [3, 1, 4, 2]]
     */
    public int[][] nQueens(int n)
    {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,new ArrayList<>(),n);
        int[][] ret=new int[result.size()][];
        System.out.println(result);
        for(int i=0;i< ret.length;i++)
        {
            ret[i]=new int[result.get(i).size()];
            for(int j=0;j<ret[i].length;j++)
                ret[i][j]=result.get(i).get(j);
        }
        return ret;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int n)
    {
        if(temp.size()==n)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!isValid(temp,i,n))
                continue;
            temp.add(i);
            helper(result,temp,n);
            temp.remove(temp.size()-1);
        }
    }

    public boolean isValid(List<Integer> temp, int val, int n)
    {
        int idx=temp.size();
        int x1=val-1,x2=val+1;
        for(int i=temp.size()-1;i>=0;i--)
        {
            int x=temp.get(i);
            if(x==x1 || x==x2 || x==val)
                return false;
            x1--;
            x2++;
        }
        return true;
    }

    public static void main(String[] args)
    {
        NQueens obj=new NQueens();
        System.out.println(obj.nQueens(5));
    }
}
