import java.util.*;
public class BusyHolidays
{
    /*
    To celebrate Cyber Monday, Instacart has decided to give its shoppers (employees that shop at grocery stores and deliver orders to customers) a break.
    For a 24h period, every shopper only has to make 1 delivery, after which his/her workday is over.
    However, since providing customers with a reliable shopping experience is Instacart's #1 priority, it is important to ensure that each order is fulfilled and delivered as promised.

    You are given a list of orders with the time periods when they should be completed, and the time leadTime it takes to fulfill each order.
    Knowing the time period each shopper is available (shoppers), find out whether the current number of shoppers is enough to fulfill all orders.

    A shopper can fulfill an order if he/she can both start and finish it in the time period specified for this order.

    Example

    For

    shoppers = [["15:10", "16:00"],
                ["17:40", "22:30"]]
    orders = [["17:30", "18:00"],
              ["15:00", "15:45"]]
    and leadTime = [15, 30], the output should be
    busyHolidays(shoppers, orders, leadTime) = true.

    The first shopper can take the second order, and the second shopper can take the first one.

    For

    shoppers = [["15:10", "16:00"],
                ["17:50", "22:30"],
                ["13:00", "14:40"]]
    orders = [["14:30", "15:00"]]
    and leadTime = [15], the output should be
    busyHolidays(shoppers, orders, leadTime) = false.

    None of the shoppers can fulfill the given order. The first two will be unavailable at the time of the order and the last one won't be able to finish it in time, since the earliest time the order can be completed is 14:30 + 15 minutes = 14:45.
     */

    public boolean busyHolidays(String[][] shoppers, String[][] orders, int[] leadTime)
    {
        int[][] o=new int[orders.length][2];
        int[][] s=new int[shoppers.length][3];

        for(int i=0;i<orders.length;i++)
            o[i]=new int[]{helper(orders[i][0]),helper(orders[i][1]),leadTime[i]};

        for(int i=0;i<shoppers.length;i++)
            s[i]=new int[]{helper(shoppers[i][0]),helper(shoppers[i][1])};

        Arrays.sort(s, new Comparator<int[]>() {
            public int compare(int[] i, int[] j)
            {
                return i[1]-j[1];
            }
        });

        Arrays.sort(o, new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                return (i[1]-i[2])-(j[1]-j[2]);
            }
        });

        boolean[] visited=new boolean[s.length];
        for(int i=0;i<o.length;i++)
        {
            boolean flag=false;
            for(int j=0;j<s.length;j++)
            {
                if(!visited[j])
                {
                    if(Math.max(s[j][0],o[i][0])+o[i][2]<=Math.min(s[j][1],o[i][1]))
                    {
                        flag=true;
                        visited[j]=true;
                        break;
                    }
                }
            }
            if(!flag)
                return false;
        }
        return true;
    }

    public int helper(String str)
    {
        String[] s=str.split(":");
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }

}
