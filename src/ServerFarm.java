import java.util.*;
public class ServerFarm
{
    /*
    Two Sigma engineers process large amounts of data every day, much more than any single server could possibly handle.
    Their solution is to use collections of servers, or server farms, to handle the massive computational load.
    Maintaining the server farms can get quite expensive, and because each server farm is simultaneously used by a number of different engineers, making sure that the servers handle their backlogs efficiently is critical.

    Your goal is to optimally distribute a list of jobs between servers within the same farm. Since this problem cannot be solved in polynomial time, you want to implement an approximate solution using the Longest Processing Time (LPT) algorithm.
    This approach sorts the jobs by their associated processing times in descending order and then assigns them to the server that's going to become available next.
    If two operations have the same processing time the one with the smaller index is listed first. If there are several servers with the same availability time, then the algorithm assigns the job to the server with the smallest index.

    Given a list of job processing times, determine how the LPT algorithm will distribute the jobs between the servers within the farm.

    Example

    For jobs = [15, 30, 15, 5, 10] and servers = 3, the output should be

    serverFarm(jobs, servers) = [[1],
                                 [0, 4],
                                 [2, 3]]
    job with index 1 goes to the server with index 0;
    job with index 0 goes to server 1;
    job with index 2 goes to server 2;
    server 1 is going to be available next, since it got the job with the shortest processing time (15). Thus job 4 goes to server 1;
    finally, job 3 goes to server 2.
     */

    public int[][] serverFarm(int[] jobs, int servers)
    {
        List<Integer>[] serverLists=new List[servers];
        for(int i=0;i<servers;i++)
            serverLists[i]=new ArrayList<Integer>();
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i< jobs.length;i++)
        {
            map.putIfAbsent(jobs[i],new PriorityQueue<>());
            map.get(jobs[i]).offer(i);
        }
        Arrays.sort(jobs);
        int[] serverLoad=new int[servers];
        for(int i=jobs.length-1;i>=0;i--)
        {
            int job_idx=map.get(jobs[i]).poll();
            int loadIdx=getNextServer(jobs[i],serverLoad);
            serverLoad[loadIdx]+=jobs[i];
            serverLists[loadIdx].add(job_idx);
        }

        for(List<Integer> temp:serverLists)
            System.out.println(temp);
        int[][] ret=new int[serverLists.length][];
        for(int i=0;i<serverLists.length;i++)
        {
            ret[i]=new int[serverLists[i].size()];
            for(int j=0;j<serverLists[i].size();j++)
                ret[i][j]=serverLists[i].get(j);
        }

        return ret;
    }

    public int getNextServer(int cost, int[] serverLoad)
    {
        int min=Integer.MAX_VALUE;
        int minIdx=-1;
        for(int i=0;i<serverLoad.length;i++)
        {
            if(serverLoad[i]<min)
            {
                min=serverLoad[i];
                minIdx=i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args)
    {
        ServerFarm obj=new ServerFarm();
        //System.out.println(obj.serverFarm(new int[]{15,30,15,5,10},3));
        //System.out.println(obj.serverFarm(new int[]{4,2,5},2));
        System.out.println(obj.serverFarm(new int[]{5, 3, 5, 3, 7},2));
    }
}

