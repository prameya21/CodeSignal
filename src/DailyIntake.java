import java.util.*;
public class DailyIntake
{
    /*
    The FDA recommends that for a healthy, balanced diet, a person on average needs around 2,000 Kcal a day to maintain their weight.
    As a result, Instacart is set to release a new feature that will help customers control their daily intake of calories.
    Given a list of items in a customer's cart, it will show the items that can be consumed in one day such that their total caloric value is as close to 2000 as possible.

    Knowing the caloricValue of each bought item, return the 0-based indices of the items to be consumed in one day. If there is more than one option, return the lexicographically smallest one.

    Example

    For caloricValue = [400, 800, 400, 500, 350, 350], the output should be
    dailyIntake(caloricValue) = [0, 2, 3, 4, 5].

    Caloric value of items [1, 3, 4, 5] and [0, 2, 3, 4, 5] both sum up to 2000 but since [0, 2, 3, 4, 5] is lexicographically smaller than [1, 3, 4, 5], the answer is [0, 2, 3, 4, 5].

    For caloricValue = [150, 900, 1000], the output should be
    dailyIntake(caloricValue) = [0, 1, 2].

    The total sum of all items (i.e. 2050) is 50 Kcal larger than 2000, so the answer is [0, 1, 2].
     */

    int min=Integer.MAX_VALUE;
    List<Integer> res;
    public int[] dailyIntake(int[] caloricValue)
    {
        if(caloricValue.length==0)
            return new int[0];
        if(caloricValue.length==1 && caloricValue[0]>2000)
            return new int[0];

        res=new ArrayList<>();
        helper(caloricValue,0,0,new ArrayList<>());
        System.out.println(res);
        return null;
    }

    public void helper(int[] nums, int idx, int sum, List<Integer> temp)
    {

        if(min>(Math.abs(sum-2000)) && temp.size()!=0)
        {
            min=Math.abs(sum-2000);
            res=new ArrayList<>(temp);

        }
        for(int i=idx;i<nums.length;i++)
        {
            temp.add(i);
            helper(nums,i+1,sum+nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int[] cal=new int[]{400, 800, 400, 500, 350, 350};
        DailyIntake obj=new DailyIntake();
        obj.dailyIntake(cal);
    }
}
