import java.util.*;
public class OptimalStockBasket
{
    /*
    You are picking a series of optimum stocks for your investment portfolio. Thankfully, you have at your disposal a tool called ACME optimizer.
    For each stock it provides the expected future return in 1 year, as well as the expected risk during the same period.
    Your goal is to implement a stock picker which will maximize the sum of expected future returns while keeping the total risk within your risk budget (riskBudget).

    Example

    For stocks = [[-1, 2], [10, 15], [11, 13], [9, 10]] and riskBudget = 30, the output should be
    optimalStockBasket(stocks, riskBudget) = 21.

    It's a bad idea to pick the first stock because its expected future return is negative.
    You can pick no more than two stocks from the remaining three because 15 + 13 + 10 > 30 (i.e. the total risk exceeds the risk budget if you pick all three of them).
    On the other hand, you can pick any pair of stocks because 15 + 13 ≤ 30, 15 + 10 ≤ 30, 13 + 10 ≤ 30.
    To maximize the sum of expected future returns according to ACME optimizer predictions you need to pick the second and third stocks (1-based). The total future return in this case equals 10 + 11 = 21.
     */

    public int optimalStockBasket(int[][] stocks, int riskBudget)
    {
        if(stocks==null || stocks.length==0)
            return 0;
        return helper(stocks,0,0,riskBudget,new HashMap<>());
    }

    public int helper(int[][] stocks, int idx, int risk, int riskBudget,Map<String,Integer> memo)
    {
        if(risk>riskBudget || idx>stocks.length)
            return Integer.MIN_VALUE;
        if(idx==stocks.length)
            return 0;
        if(stocks[idx][0]<0)
            return helper(stocks,idx+1,risk,riskBudget,memo);
        String key=idx+","+risk;
        if(memo.containsKey(key))
            return memo.get(key);

        int c1=helper(stocks,idx+1,risk,riskBudget,memo);
        int c2=helper(stocks,idx+1,risk+stocks[idx][1],riskBudget,memo);
        c2=c2==Integer.MIN_VALUE?Integer.MIN_VALUE:c2+stocks[idx][0];
        memo.put(key,Math.max(c1,c2));
        return Math.max(c1,c2);
    }

    public static void main(String[] args)
    {
        int[][] stocks={{-1,2},{10,15},{11,13},{9,10}};
        OptimalStockBasket obj=new OptimalStockBasket();
        System.out.println(obj.optimalStockBasket(stocks,30));
    }

}
