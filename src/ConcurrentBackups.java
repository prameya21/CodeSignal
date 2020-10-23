import java.util.Arrays;

public class ConcurrentBackups
{
    /*
    Datto is designed to perform backups as quickly as possible, which is usually achieved by using multiple threads. In this task, assume that all of your available threads are backing up documents at the same 1Mb/sec speed.

    Given an array of documents sizes that you need to back up and the number of available threads, return the minimum amount of time needed to back up all the files (a single thread can only be backing up one document at any given moment).

    Example

    For threads = 2 and documents = [4, 2, 5],
    the output should be concurrentBackups(threads, documents) = 6.

    The optimal solution is to send the documents of sizes 4 and 2 to the first thread and the document of size 5 to the second one. This way the first thread will finish its work in 6 seconds, and the second one in 5, so after 6 seconds the backup will be complete.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer threads

    A positive integer, the number of threads.

    Guaranteed constraints:
    1 ≤ threads ≤ 5.

    [input] array.integer documents

    Array of positive integers. documents[i] represents the size of the ith document in Mbs.

    Guaranteed constraints:
    0 ≤ documents.length ≤ 10,
    1 ≤ documents[i] ≤ 50.

    [output] integer

    The minimum amount of time needed to back up all the files, in seconds.
     */


    public int concurrentBackups(int threads, int[] documents)
    {
        if(documents==null|| documents.length==0)
            return 0;
        Arrays.sort(documents);
        int[] tWeight=new int[threads];
        int sum=0;
        for(int d: documents)
            sum+=d;
        int bestTime=(int) Math.ceil((double)sum / threads);
        boolean flag;

        for(int i=documents.length-1;i>=0;i--)
        {
            flag=false;
            for(int j=0;j<threads;j++)
            {
                if(tWeight[j]+documents[i]<=bestTime)
                {
                    tWeight[j]+=documents[i];
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                int idx=helper(tWeight);
                tWeight[idx]+=documents[i];
            }
        }
        int res=0;
        for(int i:tWeight)
            res=Math.max(res,i);

        return res;
    }

    public int helper(int[] nums)
    {
        int minIdx=0,min=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<=min)
            {
                minIdx=i;
                min=nums[i];
            }
        }
        return minIdx;
    }


    public static void main(String[] args)
    {
        ConcurrentBackups obj=new ConcurrentBackups();
        System.out.println(obj.concurrentBackups(2,new int[]{5,3,5,3,7}));
    }
}
