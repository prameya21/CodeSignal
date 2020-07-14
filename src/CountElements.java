public class CountElements
{
    /*
    You've been invited to a job interview at a famous company that tests programming challenges. To evaluate your coding skills, they have asked you to parse a given problem's input given as an inputString string, and count the number of primitive type elements within it.

    The inputString can be either a primitive type variable or an array (possibly multidimensional) that contains elements of the primitive types.
    A primitive type variable can be:

    an integer number;
    a string, which is surrounded by " characters (note that it may contain any character except ");
    a boolean, which is either true or false.
    Return the total number of primitive type elements inside inputString.

    Example

    For inputString = "[[0, 20], [33, 99]]", the output should be
    countElements(inputString) = 4;
    For inputString = "[ "one", 2, "three" ]", the output should be
    countElements(inputString) = 3;
    For inputString = "true", the output should be
    countElements(inputString) = 1;
    For inputString = "[[1, 2, [3]], 4]", the output should be
    countElements(inputString) = 4.
     */

    public int countElements(String S)
    {
        if(S.length()==0 || S.length()==1)
            return S.length();

        String str=parseString(S);

        if(!str.contains(","))
            return 1;
        String[] data=str.split(",");
        int count=0;
        for(String s:data)
        {
            if(s!=null && s.length()>0)
                count++;
        }
        return count;
    }

    public String parseString(String str)
    {
        if(!str.contains("\""))
            return str;

        while(str.contains("\""))
        {
            int first=str.indexOf("\"");
            int second=str.indexOf("\"",first+1);
            String sub=str.substring(first,second+1);
            if(sub.length()==0)
                str=str.replace(sub,"");
            else
                str=str.replace(sub,"#");

        }
        return str;
    }


    public static void main(String[] args)
    {
        CountElements obj=new CountElements();
        String tc1="[[0, 20], [33, 99]]";
        String tc2= "[ \"one\", 2, \"three\" ]";
        String tc3="[\"oh, no! kind, of, tricky\", \"test, case\"]";

        System.out.println(obj.countElements(tc1));
        System.out.println(obj.countElements(tc2));
        System.out.println(obj.countElements(tc3));
    }
}
