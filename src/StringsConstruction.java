public class StringsConstruction
{
    /*
    Given two strings a and b, both consisting only of lowercase English letters, your task is to calculate how many strings equal to a can be constructed using only letters from the string b? Each letter can be used only once and in one string only.

    Example

    For a = "abc" and b = "abccba", the output should be stringsConstruction(a, b) = 2.

    We can construct 2 strings a = "abc" using only letters from the string b.

    For a = "ab" and b = "abcbcb", the output should be stringsConstruction(a, b) = 1.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string a

    String to construct, containing only lowercase English letters.

    Guaranteed constraints:
    1 ≤ a.length ≤ 105.

    [input] string b

    String containing needed letters, containing only lowercase English letters.

    Guaranteed constraints:
    1 ≤ b.length ≤ 105.

    [output] integer

    The number of strings a that can be constructed from the string b.
     */

    public int stringsConstruction(String a, String b)
    {
        if(a.length()>b.length())
            return 0;
        if(a.equals(b))
            return 1;
        int[] amap=new int[26];
        for(char c:a.toCharArray())
            amap[c-'a']++;

        int[] bmap=new int[26];
        for(char c:b.toCharArray())
            bmap[c-'a']++;

        int min=Integer.MAX_VALUE;
        for(char c:a.toCharArray())
            min=Math.min(min,bmap[c-'a']/amap[c-'a']);


        return min;
    }

    public static void main(String[] args)
    {
        StringsConstruction obj=new StringsConstruction();
        System.out.println(obj.stringsConstruction("aaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    }
}
