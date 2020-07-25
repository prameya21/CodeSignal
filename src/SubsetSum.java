public class SubsetSum
{
    /*
    Given an array of numbers arr, determine whether arr can be divided into two subsets for which the sum of elements in both subsets is the same.

    Example

    For arr = [3, 5, 16, 8], the output should be
    subsetSum(arr) = true.

    It is possible to partition this array into two subsets that have a sum of 16: [16] and [3, 5, 8].

    For arr = [5, 7, 1], the output should be
    subsetSum(arr) = false.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.integer arr

    The given set of numbers.

    Guaranteed constraints:
    3 ≤ arr.length ≤ 100,
    0 ≤ arr[i] ≤ 1000.

    [output] boolean

    Return true if arr can be divided into two subsets, the elements of which have equal sums. Return false otherwise.
     */

    boolean subsetSum(int[] arr)
    {
        if(arr==null || arr.length==0)
            return false;
        int sum=0;
        for(int i:arr)
            sum+=i;
        if(sum%2!=0)
            return false;
        return helper(arr,0,0,sum/2);
    }

    public boolean helper(int[] arr, int idx, int sum, int total)
    {
        if(idx>=arr.length)
            return false;
        if(sum==total)
            return true;
        boolean ans=false;
        for(int i=idx;i<arr.length;i++)
            ans|=helper(arr,i+1,sum+arr[i],total);

        return ans;
    }

    public static void main(String[] args)
    {
        SubsetSum obj=new SubsetSum();
        System.out.println(obj.subsetSum(new int[]{3,5,8}));
    }
}
