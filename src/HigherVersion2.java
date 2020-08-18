import java.util.Arrays;

public class HigherVersion2
{
    /*
    You have two version strings composed of several non-negative decimal fields that are separated by periods (".").
    Both strings contain an equal number of numeric fields. Return 1 if the first version is higher than the second version, -1 if it is smaller, and 0 if the two versions are the same.

    The syntax follows the regular semver (semantic versioning) ordering rules:

    1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
    < 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
    Example

    For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
    higherVersion2(ver1, ver2) = 1;
    For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
    higherVersion2(ver1, ver2) = -1;
    For ver1 = "1.0.5" and ver2 = "1.00.05", the output should be
    higherVersion2(ver1, ver2) = 0.
     */

    public int higherVersion2(String ver1, String ver2)
    {
        String[] v1=ver1.split("\\.");
        String[] v2=ver2.split("\\.");

        int idx1=0,idx2=0;
        while(idx1<v1.length || idx2<v2.length)
        {
            Integer op1=idx1<v1.length?Integer.parseInt(v1[idx1]):0;
            Integer op2=idx2<v2.length?Integer.parseInt(v2[idx2]):0;
            int cmp=op1.compareTo(op2);
            if(cmp!=0)
                return cmp;
            idx1++;
            idx2++;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        HigherVersion2 obj=new HigherVersion2();
        System.out.println(obj.higherVersion2("1.2","1.2.5"));
    }


}
