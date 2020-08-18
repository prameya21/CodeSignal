public class BiggestPlus
{
    /*
    Given a matrix that contains only the characters '0' and '1', find the biggest plus sign (+) formed by 1s in this matrix and return its size.
    Size, in this case, indicates the length of the plus sign's edges. In order to be a valid plus sign, the edges must be of equal length.

    For example, a plus sign with a size of k in matrix starts at cell (x, y).
    The plus sign's edges are (x - k, y), (x - k + 1, y), ..., (x + k, y) and (x, y - k), (x, y - k + 1), ..., (x, y + k), all with a length of k.

    Example

    For

      matrix = ["0010010",
                "1010101",
                "1111111",
                "0010000",
                "0000000"]
    the output should be biggestPlus(matrix) = 1.

    Here, the biggest plus sign is centered at cell (2, 2) (0-based) and has a size of 1 since the downward facing edge is short.
     */

    public int biggestPlus(String[] matrix)
    {
        int size=0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length();j++)
                if(matrix[i].charAt(j)=='1')
                    size=Math.max(size,helper(matrix,i,j));

        return size;
    }


    public int helper(String[] matrix,int i, int j)
    {
        int size=0;
        int left=j-1, right=j+1,up=i-1,down=i+1;

        while(left>=0 && matrix[i].charAt(left)=='1' && right<matrix[i].length() && matrix[i].charAt(right)=='1' && up>=0 && matrix[up].charAt(j)=='1' && down<matrix.length && matrix[down].charAt(j)=='1')
        {
            size++;
            left--;
            right++;
            up--;
            down++;
        }
        return size;
    }

    public static void main(String[] args)
    {
        String[] matrix = {"0010010","1010101","1111111","0010000","0000000"};
        BiggestPlus obj=new BiggestPlus();
        System.out.println(obj.biggestPlus(matrix));
    }
}
