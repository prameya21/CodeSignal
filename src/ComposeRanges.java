import java.util.ArrayList;
import java.util.List;

public class ComposeRanges
{
    /*
    Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it contains.

    Example

    For nums = [-1, 0, 1, 2, 6, 7, 9], the output should be
    composeRanges(nums) = ["-1->2", "6->7", "9"].

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.integer nums

    A sorted array of unique integers.

    Guaranteed constraints:
    0 ≤ nums.length ≤ 15,
    -(231 - 1) ≤ nums[i] ≤ 231 - 1.

    [output] array.string
     */

    public String[] composeRanges(int[] nums)
    {
        if(nums==null || nums.length==0)
            return null;
        List<String> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int start=nums[i];
            int j=i;
            while(j+1<nums.length && nums[j]+1==nums[j+1])
                j++;
            int end=nums[j];
            if(start==end)
                result.add(start+"");
            else
                result.add(start+"->"+end);
            i=j;
        }
        System.out.println(result);
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args)
    {
        ComposeRanges obj=new ComposeRanges();
        System.out.println(obj.composeRanges(new int[]{-1,0,1,2,6,7,9}));
    }

}
