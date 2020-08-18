import java.util.Arrays;

public class SumInRange
{
    /*
    You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based).
    Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each query, then add all of the sums for all the queries together.
    Return that number modulo 109 + 7.

    Example

    For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
    sumInRange(nums, queries) = 10.

    The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
     */


    public int sumInRange2(int[] nums, int[][] queries)
    {
        int sum=0;
        for(int[] q:queries)
        {
            int val=0;
            for(int i=q[0];i<=q[1];i++)
                val+=nums[i];
            sum+=val;
        }
        return sum % 1000000007;
    }
    public int sumInRange(int[] nums, int[][] queries)
    {
        int[] preSum=new int[nums.length+1];
        for(int i=1;i<preSum.length;i++)
            preSum[i]=preSum[i-1]+nums[i-1];
        int sum=0;
        for(int[] q:queries)
        {
            int l=q[0], r=q[1];
            int val=preSum[r+1]-preSum[l];
            sum+=val;
        }
        return sum%1000000007;
    }
    public static void main(String[] args)
    {
        int[] nums=new int[]{-4, -18, -22, -14, -33, -47, -29, -35, -50, -19};
        int[][] queries={{2,9},{5,6},{1,2},{2,2},{4,5}};

        SumInRange obj=new SumInRange();
        System.out.println(obj.sumInRange(nums,queries));
        System.out.println(obj.sumInRange2(nums,queries));
    }

}
