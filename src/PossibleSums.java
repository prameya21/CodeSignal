import java.util.HashSet;
import java.util.Set;

public class PossibleSums
{
    /*
    You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it.
    You want to know how many distinct sums you can make from non-empty groupings of these coins.

    Example

    For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
    possibleSums(coins, quantity) = 9.

    Here are all the possible sums:

    50 = 50;
    10 + 50 = 60;
    50 + 100 = 150;
    10 + 50 + 100 = 160;
    50 + 50 = 100;
    10 + 50 + 50 = 110;
    50 + 50 + 100 = 200;
    10 + 50 + 50 + 100 = 210;
    10 = 10;
    100 = 100;
    10 + 100 = 110.
    As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
     */

    public int possibleSums(int[] coins, int[] quantity)
    {
        HashSet<Integer> sums = new HashSet<Integer>();
        sums.add(0);

        for(int i=0; i<coins.length; i++) {
            int coin = coins[i];
            HashSet<Integer> currentSums = new HashSet<Integer>();
            for(Integer sum : sums) {
                for(int j=1; j<=quantity[i]; j++) {
                    currentSums.add(sum + coin*j);
                }
            }
            sums.addAll(currentSums);
        }

        return sums.size() - 1;
    }


    public static void main(String[] args)
    {
        PossibleSums obj=new PossibleSums();
        System.out.println(obj.possibleSums(new int[]{1,2},new int[]{50000,2}));
    }
}
