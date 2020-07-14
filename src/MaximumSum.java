import java.util.*;
public class MaximumSum
{
    /*
    You are given an array of integers a. A range sum query is defined by a pair of non-negative integers l and r (l <= r).
    The output to a range sum query on the given array a is the sum of all the elements of a that have indices from l to r, inclusive.

    You have the array a and a list of range sum queries q. Find an algorithm that can rearrange the array a in such a way that the total sum of all of the query outputs is maximized, and return this total sum.

    Example

    For a = [9, 7, 2, 4, 4] and q = [[1, 3], [1, 4], [0, 2]], the output should be
    maximumSum(a, q) = 62.

    You can get this sum if the array a is rearranged to be [2, 9, 7, 4, 4]. In that case, the first range sum query [1, 3] returns the sum 9 + 7 + 4 = 20,
    the second query [1, 4] returns the sum 9 + 7 + 4 + 4 = 24,
    and the third query [0, 2] returns the sum 2 + 9 + 7 = 18.
    The total sum will be 20 + 24 + 18 = 62.
     */

    int max=Integer.MIN_VALUE;
    public int maximumSum(int[] a, int[][] q)
    {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i:a)
            freq.put(i,freq.getOrDefault(i,0)+1);
        getPerms(freq,new ArrayList<>(), q, a.length);
        return max;
    }

    public void getPerms(Map<Integer,Integer> freq, List<Integer> temp, int[][] q, int len)
    {
        if(temp.size()==len)
        {
            int currMax=getMax(q,temp);
            max=Math.max(max,currMax);
        }
        else
        {
            for(int i:freq.keySet())
            {
                if(freq.get(i)>0)
                {
                    freq.put(i,freq.get(i)-1);
                    temp.add(i);
                    getPerms(freq,temp,q,len);
                    temp.remove(temp.size()-1);
                    freq.put(i,freq.get(i)+1);

                }
            }
        }
    }

    public int getMax(int[][]q, List<Integer> temp)
    {
        int ans=0;
        for(int[] i:q)
        {
            for(int j=i[0];j<=i[1];j++)
            {
                ans+=temp.get(j);
            }
        }
        return ans;
    }


    public static void main(String[] args)
    {
        MaximumSum obj=new MaximumSum();
        System.out.println(obj.maximumSum(new int[]{9,7,2,4,4}, new int[][]{{1,3},{1,4},{0,2}}));
    }
}
