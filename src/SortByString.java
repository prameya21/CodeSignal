import java.util.Arrays;
import java.util.Comparator;

public class SortByString
{
    /*
    Sort the letters in the string s by the order they occur in the string t.

    Example

    For s = "weather" and t = "therapyw", the output should be
    sortByString(s, t) = "theeraw";

    For s = "good" and t = "odg", the output should be
    sortByString(s, t) = "oodg".

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string s

    A string consisting only of lowercase English letters.

    Guaranteed constraints:
    0 ≤ s.length ≤ 104.

    [input] string t

    A string consisting only of unique lowercase English letters. It is guaranteed that t contains all of the letters that occur in s.

    Guaranteed constraints:
    0 ≤ t.length ≤ 26.

    [output] string
     */

    public String sortByString(String s, String t)
    {
        int[] map=new int[26];
        for(char c:s.toCharArray())
            map[c-'a']++;
        StringBuilder sb=new StringBuilder();
        for(char c:t.toCharArray())
        {
            while(map[c-'a']>0)
            {
                sb.append(c);
                map[c-'a']--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        SortByString obj = new SortByString();
        System.out.println(obj.sortByString("weather","therapyw"));
    }
}
