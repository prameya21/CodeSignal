public class RemoveDuplicateAdjacent
{
    /*
    Given a string s, recursively remove any adjacent duplicate characters that it contains.

    Example

    For s = "cooodefightssforrrcodee", the output should be
    removeDuplicateAdjacent(s) = "cdefightfocod";
    For s = "acaaabbbacdddd", the output should be
    removeDuplicateAdjacent(s) = "acac".
    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string s

    A string composed of lowercase English letters.

    Guaranteed constraints:
    1 ≤ s.length ≤ 50.

    [output] string

    A string obtained by removing all adjacent duplicates from the input string.
     */

    public String removeDuplicateAdjacent(String s)
    {
        if(s==null || s.length()==0)
            return s;
        if(containsAdjacent(s))
        {
            s=helper(s);
            return removeDuplicateAdjacent(s);
        }
        return s;

    }
    public boolean containsAdjacent(String s)
    {
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)==s.charAt(i-1))
                return true;

        return false;
    }
    public String helper(String s)
    {
        StringBuilder sb=new StringBuilder();
        char[] ch=s.toCharArray();
        int i=0,j=0;
        while(j<ch.length)
        {
            if(j+1<ch.length && ch[j]==ch[j+1])
            {
                while(j+1<ch.length && ch[j]==ch[j+1])
                {
                    j++;
                }
            }
            else
                sb.append(ch[j]+"");
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        RemoveDuplicateAdjacent obj=new RemoveDuplicateAdjacent();
        System.out.println(obj.removeDuplicateAdjacent("cooodefightssforrrcodee"));
        System.out.println(obj.removeDuplicateAdjacent("acaaabbbacdddd"));
        System.out.println(obj.removeDuplicateAdjacent("mississipie"));

    }
}
