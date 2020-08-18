import java.util.Stack;

public class DecodeString
{
    /*
    Given an encoded string, return its corresponding decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. Note: k is guaranteed to be a positive integer.

    Note that your solution should have linear complexity because this is what you will be asked during an interview.

    Example

    For s = "4[ab]", the output should be
    decodeString(s) = "abababab";

    For s = "2[b3[a]]", the output should be
    decodeString(s) = "baaabaaa";

    For s = "z1[y]zzz2[abc]", the output should be
    decodeString(s) = "zyzzzabcabc".
     */

    public String decodeString(String s)
    {
        if(s==null || s.length()==0)
            return s;
        Stack<Integer> counter=new Stack<>();
        Stack<String> data=new Stack<>();
        data.push("");
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                int j=i;
                while(s.charAt(i+1)>='0' && s.charAt(i+1)<='9')
                    i++;
                int val=Integer.parseInt(s.substring(j,i+1));
                counter.push(val);
            }
            else if(s.charAt(i)=='[')
                data.push("");

            else if(s.charAt(i)==']')
            {
                int ctr=counter.pop();
                String str=data.pop();
                String val="";
                for(int k=0;k<ctr;k++)
                    val+=str;
                if(data.isEmpty())
                    data.push(val);
                else
                    data.push(data.pop()+val);
            }
            else
            {
                String str=data.pop();
                str+=String.valueOf(s.charAt(i));
                data.push(str);
            }
        }
        return data.pop();
    }


    public static void main(String[] args)
    {
        DecodeString obj=new DecodeString();
        System.out.println(obj.decodeString("z1[y]zzz2[abc]"));
    }
}
