public class SortedSquaredArray
{
    /*
    Note: Come up with a linear solution, since that is what you would be asked to do in an interview.

    You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those integers.

    Example

    For array = [-6, -4, 1, 2, 3, 5], the output should be
    sortedSquaredArray(array) = [1, 4, 9, 16, 25, 36].

    The array of squared integers from array is: [36, 16, 1, 4, 9, 25]. When sorted, it becomes: [1, 4, 9, 16, 25, 36].
     */

    public  int[] sortedSquaredArray(int[] array)
    {
        if(array.length==0)
            return array;
        int l=0,r=array.length-1;
        int[] ret=new int[array.length];

        for(int i=array.length-1;i>=0;i--)
        {
            int lval=array[l]*array[l];
            int rval=array[r]*array[r];
            if(lval<rval)
            {
                ret[i]=rval;
                r--;
            }
            else
            {
                ret[i]=lval;
                l++;
            }
        }
        return ret;
    }

    public static void main(String[] args)
    {
        SortedSquaredArray obj=new SortedSquaredArray();
        int[] ret=obj.sortedSquaredArray(new int[]{-6,-4,1,2,3,5});
        for(int i:ret)
            System.out.println(i);
    }
}
