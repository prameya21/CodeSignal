public class HouseRobber
{
    /*
        You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount of money hidden.
        The only thing stopping you from robbing all of them in one night is that adjacent houses on the street have a connected security system.
        The system will automatically trigger an alarm if two adjacent houses are broken into on the same night.

        Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the maximum amount of money you can rob in one night without triggering an alarm.

        Example

        For nums = [1, 1, 1], the output should be
        houseRobber(nums) = 2.

        The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.

        Input/Output

        [execution time limit] 3 seconds (java)

        [input] array.integer nums

        An array representing the amount of money that each house on the street has.

        Guaranteed constraints:
        0 ≤ nums.length ≤ 100,
        0 ≤ nums[i] ≤ 500.

        [output] integer
     */
    public int houseRobber(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;
        Integer[] memo=new Integer[nums.length];
        return helper(nums,nums.length-1,memo);
    }

    public int helper(int[] nums, int n, Integer[] memo)
    {
        if(n<0)
            return 0;
        if(memo[n]!=null)
            return memo[n];
        memo[n]=Math.max(nums[n]+helper(nums,n-2,memo),helper(nums,n-1,memo));
        return memo[n];
    }

    public static void main(String[] args)
    {
        HouseRobber obj=new HouseRobber();
        System.out.println(obj.houseRobber(new int[]{2,9,7,1}));
    }

}
