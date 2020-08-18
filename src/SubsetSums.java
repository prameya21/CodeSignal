import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSums
{
    /*
    Given a sorted array of integers arr and an integer num, find all possible unique subsets of arr that add up to num. Both the array of subsets and the subsets themselves should be sorted in lexicographical order.

    Example

    For arr = [1, 2, 3, 4, 5] and num = 5, the output should be
    sumSubsets(arr, num) = [[1, 4], [2, 3], [5]].
     */
    public int[][] sumSubsets(int[] arr, int num)
    {
        if(arr==null || arr.length==0)
            return new int[0][];
        List<List<Integer>> result=new ArrayList<>();
        Set<String> visited=new HashSet<>();
        helper(arr,num,new ArrayList<>(), result,0,visited);

        System.out.println(result);
        int[][] ret=new int[result.size()][];
        for(int i=0;i< ret.length;i++)
        {
            ret[i]=new int[result.get(i).size()];
            for(int j=0;j<result.get(i).size();j++)
                ret[i][j]=result.get(i).get(j);
        }
        return ret;
    }

    public void helper(int[] arr, int num, List<Integer> temp, List<List<Integer>> result, int idx, Set<String> visited)
    {
        if(idx>arr.length || num<0)
            return;
        if(num==0 && !visited.contains(temp.toString()))
        {
            result.add(new ArrayList(temp));
            visited.add(temp.toString());
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            temp.add(arr[i]);
            helper(arr,num-arr[i],temp,result,i+1,visited);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args)
    {
        SubsetSums obj=new SubsetSums();
        System.out.println(obj.sumSubsets(new int[]{1,2,2,3,4,5},5));
    }

}
