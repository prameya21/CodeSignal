public class MapDecoding
{
    /*
    A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    You are an FBI agent and you need to determine the total number of ways that the message can be decoded.

    Since the answer could be very large, take it modulo 109 + 7.

    Example

    For message = "123", the output should be
    mapDecoding(message) = 3.

    "123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the total number of ways is 3.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] string message

    A string containing only digits.

    Guaranteed constraints:
    0 ≤ message.length ≤ 105.

    [output] integer

    The total number of ways to decode the given message.
     */

    public int mapDecoding(String message)
    {
        if(message==null || message.length()==0)
            return 1;
        int[] dp=new int[message.length()];
        char[] c=message.toCharArray();
        dp[0]=c[0]=='0'?0:1;
        for(int i=1;i<message.length();i++)
        {
            char curr=c[i];
            char prev=c[i-1];
            if(curr>='1' && curr<='9')
                dp[i]+=dp[i-1];
            if((prev=='1' && curr<='9' && curr>=0) || (prev=='2' && curr>='0' && curr<='6'))
                dp[i]+=i>2?dp[i-2]:1;

        }
        return dp[dp.length-1];
    }

    public static void main(String[] args)
    {
        MapDecoding obj=new MapDecoding();
        System.out.println(obj.mapDecoding("1221112111122221211221221212212212111221222212122221222112122212121212221212122221211112212212211211"));
    }


}
