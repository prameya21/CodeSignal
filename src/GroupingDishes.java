import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class GroupingDishes
{
    /*
        You are given a list dishes, where each element consists of a list of strings beginning with the name of the dish, followed by all the ingredients used in preparing it.
        You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

        Return an array where each element is a list beginning with the ingredient name, followed by the names of all the dishes that contain this ingredient.
        The dishes inside each list should be sorted lexicographically, and the result array should be sorted lexicographically by the names of the ingredients.

        Example

        For

        dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
        ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
        ["Quesadilla", "Chicken", "Cheese", "Sauce"],
        ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]

        the output should be

        groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
        ["Salad", "Salad", "Sandwich"],
        ["Sauce", "Pizza", "Quesadilla", "Salad"],
        ["Tomato", "Pizza", "Salad", "Sandwich"]]

        For

        dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
        ["Chicken Curry", "Chicken", "Curry Sauce"],
        ["Fried Rice", "Rice", "Onions", "Nuts"],
        ["Salad", "Spinach", "Nuts"],
        ["Sandwich", "Cheese", "Bread"],
        ["Quesadilla", "Chicken", "Cheese"]]

        the output should be

        groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
        ["Chicken", "Chicken Curry", "Quesadilla"],
        ["Nuts", "Fried Rice", "Salad"],
        ["Onions", "Fried Rice", "Pasta"]]

        Input/Output

        [execution time limit] 3 seconds (java)

        [input] array.array.string dishes

        An array of dishes, where dishes[i] for each valid i contains information about the ith dish: dishes[i][0] is the name of the dish, and all the elements after it are the ingredients of that dish.
        Both the dish name and the ingredient names consist of English letters and spaces. It is guaranteed that all dish names are different. It is also guaranteed that the ingredient names for any one dish are also pairwise distinct.

        Guaranteed constraints:
        1 ≤ dishes.length ≤ 500,
        2 ≤ dishes[i].length ≤ 10,
        1 ≤ dishes[i][j].length ≤ 50.

        [output] array.array.string
        The array containing the grouped dishes.

     */


    String[][] groupingDishes(String[][] dishes)
    {
        if(dishes==null || dishes.length==0)
            return null;

        TreeMap<String, PriorityQueue<String>> map=new TreeMap<>();
        for(String[] dish:dishes)
        {
            for(int i=1;i<dish.length;i++)
            {
                map.putIfAbsent(dish[i],new PriorityQueue<>());
                map.get(dish[i]).offer(dish[0]);
            }
        }

        Set<String> keys=map.keySet();
        for(String s:keys)
        {
            if(map.get(s).size()<2)
                map.remove(s);
        }



        String[][] ret=new String[map.size()][];
        int i=0;
        for(String key:map.keySet())
        {
            ret[i]=new String[map.get(key).size()+1];
            ret[i][0]=key;
            int j=1;
            while(!map.get(key).isEmpty())
                ret[i][j++]=map.get(key).poll();
            i++;
        }
        return ret;
    }
}
