import java.util.*;

public class StringReformatting
{
    /*
    The string s contains dashes that split it into groups of characters. You are given an integer k that represents the number of characters in groups that your output should have.
    Your goal is to return a new string that breaks s into groups with a length of k by placing dashes at the correct intervals.
    If necessary, the first group of characters can be shorter than k. It is guaranteed that there are no consecutive dashes in s.

    Example

    For s = "2-4a0r7-4k" and k = 4, the output should be
    stringReformatting(s, k) = "24a0-r74k".

    The input string "2-4a0r7-4k" is split into three groups with lengths of 1, 5 and 2. Since k = 4, you need to split the string into two groups of 4 characters each, making the output string "24a0-r74k".

    For s = "2-4a0r7-4k" and k = 3, the output should be
    stringReformatting(s, k) = "24-a0r-74k".

    Given the same input string and k = 3, split the string into groups of 2, 3, and 3 characters to get the output string of "24-a0r-74k".

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string s

    A string containing some dashes.

    Guaranteed constraints:
    1 ≤ s.length ≤ 104.

    [input] integer k

    Guaranteed constraints:
    1 ≤ k ≤ s.length.

    [output] string

    A string, reformatted so that dashes divide it into groups with a length of k or shorter.
     */


    public String stringReformatting(String s, int k)
    {
        if(s.length()==1)
            return "";
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray())
            if(c!='-')
                st.push(c);
        int ctr=0;
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            if(ctr==k)
            {
                sb.append("-");
                ctr=0;
            }
            sb.append(st.pop());
            ctr++;
        }
        return sb.reverse().toString();
    }


    public long hashMap(String[] queryType, int[][] query)
    {
        if(queryType==null || queryType.length==0)
            return 0;
        List<Integer> key=new ArrayList<>();
        List<Integer> value=new ArrayList<>();
        long ans=0;
        int keyAdd=0,valAdd=0;
        for(int i=0;i<queryType.length;i++)
        {
            if(queryType[i].equals("insert"))
            {
                key.add(query[i][0]);
                value.add(query[i][1]);
            }
            else if(queryType[i].equals("addToValue"))
                valAdd+=query[i][0];
            else if(queryType[i].equals("addToKey"))
                keyAdd+=query[i][0];
            else if(queryType[i].equals("get"))
            {
                for(int idx=0;idx<key.size();idx++)
                    key.set(idx,key.get(idx)+keyAdd);
                for(int idx=0;idx<value.size();idx++)
                    value.set(idx, value.get(idx)+valAdd);
                System.out.println(query[i][0]);
                int idx=Collections.binarySearch(key,query[i][0]);
                ans+=value.get(idx);
            }
        }
        return ans;
    }




    public static void main(String[] args)
    {
        StringReformatting obj=new StringReformatting();
        System.out.println(obj.stringReformatting("2-4a0r7-4k",3));
        String[] keys={"insert","addToValue","get","insert","addToKey","addToValue","get"};
        int[][] query={{1,2},{2},{1},{2,3},{1},{-1},{3}};

        System.out.println(obj.hashMap(keys,query));
    }
}
