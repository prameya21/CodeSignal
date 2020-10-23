public class ShoppingList
{
    /*
    As part of an Instacart beta testing group, Sara is trying out a brand new feature that automatically estimates the combined cost of the items in her handwritten shopping list.
    Her list contains both items and their prices. All Sara has to do is snap a photo of her list with the Instacart app, and she gets a quick estimate of what everything will cost.

    Sara asked for your help, so it is up to you to devise an algorithm that calculates the cost after the image is converted into plain text. All you need to do is extract all numbers from the given string items and sum them up.

    Example

    For items = "Doughnuts, 4; doughnuts holes, 0.08; glue, 3.4", the output should be
    shoppingList(items) = 7.48;
    For items = "blue suit for 24$, cape for 12.99$ & glasses for 15.70", the output should be
    shoppingList(items) = 52.69.
    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string items

    A shopping list given as a string. It is guaranteed that the only numbers in it are dollar prices for different items.
    Note that although each price is given in dollars, you do not know their exact form. Each of them can either be an integer, or a decimal number with one or two decimal places and it may or may not be followed by a dollar sign.
    However, you may assume that if there is a period ('.') between two digits, then it's a decimal mark.

    Guaranteed constraints:
    0 ≤ items.length ≤ 6 · 104.

    [output] float

    The total cost of all items.
     */

    public double shoppingList(String items)
    {
        double res=0;
        if(items==null || items.length()==0)
            return res;

        int i=0;
        while(i<items.length())
        {
            if(Character.isDigit(items.charAt(i)))
            {
                int j=i;
                while(j<items.length() && (Character.isDigit(items.charAt(j)) || items.charAt(j)=='.'))
                    j++;
                double val=Double.parseDouble(items.substring(i,j));
                res+=val;
                i=j;
            }
            else
                i++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        ShoppingList obj=new ShoppingList();
        System.out.println(obj.shoppingList("blue suit for 24$, cape for 12.99$ & glasses for 15.70"));
    }

}
