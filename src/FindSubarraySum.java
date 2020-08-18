public class FindSubarraySum
{
    /*
    You're given an unsorted array arr of positive integers and a number s.
    Your task is to find a contiguous subarray that has a sum equal to s, and return an array containing the two integers that represent its inclusive bounds.
    If there are several possible answers, return the one with the smallest left bound. If there are no answers, return [-1].

    Your answer should be 1-based, making the first position of the array 1 instead of 0.

    Example

    For s = 21 and arr = [4, 8, 9, 10, 3, 8], the output should be
    findSubarrayBySum(s, arr) = [1, 3].

    The sum of elements from the 1st position to the 3rd position (1-based) is equal to 21: 4 + 8 + 9.

    For s = 15 and arr = [1, 2, 3, 1, 4, 5, 6, 7, 8, 9, 10], the output should be
    findSubarrayBySum(s, arr) = [2, 6].

    The sum of elements from the 2nd position to the 6th position (1-based) is equal to 15: 2 + 3 + 1 + 4 + 5.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer s

    The sum of the subarray that you are searching for.

    Guaranteed constraints:
    1 ≤ s ≤ 109.

    [input] array.integer arr

    The given array.

    Guaranteed constraints:
    3 ≤ arr.length ≤ 105,
    1 ≤ arr[i] ≤ 104.
     */

    public int[] findSubarrayBySum(int s, int[] arr)
    {
        int i=0,j=0;
        int sum=0;
        while(j<arr.length)
        {
            if(sum==s)
                return new int[]{i+1,j};
            else if(sum<s)
            {
                sum+=arr[j];
                j++;
            }
            else
            {
                sum-=arr[i];
                i++;
            }
        }
        while(i<arr.length)
        {
            if(sum==s)
                return new int[]{i+1,j};
            else
            {
                sum-=arr[i];
                i++;
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args)
    {
        int[] arr=new int[]{4, 8, 9, 10, 3, 8};
        int[] arr2=new int[]{135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        FindSubarraySum obj=new FindSubarraySum();
        int[] ret=obj.findSubarrayBySum(468,arr2);
        for(int i:ret)
            System.out.println(i);

    }
}
