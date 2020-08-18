import java.util.*;
public class CombinationSum
{
    /*
    Given an array of integers a and an integer sum, find all of the unique combinations in a that add up to sum.
    The same number from a can be used an unlimited number of times in a combination.
    Elements in a combination (a1 a2 … ak) must be sorted in non-descending order, while the combinations themselves must be sorted in ascending order.
    If there are no possible combinations that add up to sum, the output should be the string "Empty".

    Example

    For a = [2, 3, 5, 9] and sum = 9, the output should be
    combinationSum(a, sum) = "(2 2 2 3)(2 2 5)(3 3 3)(9)".

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.integer a

    An array of positive integers.

    Guaranteed constraints:
    2 ≤ a.length ≤ 11,
    1 ≤ a[i] ≤ 9.

    [input] integer sum

    Guaranteed constraints:
    1 ≤ sum ≤ 25.

    [output] string

    All possible combinations that add up to a given sum, or "Empty" if there are no possible combinations.
     */

    String combinationSum(int[] a, int sum)
    {
        Arrays.sort(a);
        List<List<Integer>> result=new ArrayList<>();
        helper(a,sum,new ArrayList<>(),result,0,new HashSet<>());
        StringBuilder sb=new StringBuilder();
        for(List<Integer> temp:result)
            sb.append(temp.toString());

        return sb.length()==0?"Empty":sb.toString().replace("[","(").replace("]",")").replace(", "," ");
    }

    public void helper(int[] nums, int sum, List<Integer> temp, List<List<Integer>> result, int idx,Set<String> visited)
    {
        if(sum<0)
            return;
        if(sum==0 && !visited.contains(temp.toString()))
        {
            result.add(new ArrayList<>(temp));
            visited.add(temp.toString());
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            temp.add(nums[i]);
            helper(nums,sum-nums[i],temp,result,i,visited);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args)
    {
        CombinationSum obj=new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2,3,5,9},9));
    }
}
