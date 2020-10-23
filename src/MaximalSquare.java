public class MaximalSquare
{
    /*
    You have a 2D binary matrix that's filled with 0s and 1s. In the matrix, find the largest square that contains only 1s and return its area.

    Example

    For

    matrix = [
        ['1', '0', '1', '1', '1'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0'],
        ['1', '0', '0', '1', '0']
    ]
    the output should be
    maximalSquare(matrix) = 9.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.char matrix

    Guaranteed constraints:
    0 ≤ matrix.length ≤ 100,
    1 ≤ matrix[i].length ≤ 100,
    0 ≤ matrix[i][j] ≤ 1.

    [output] integer

    An integer that represents the area of the largest square in the given matrix that is composed only of 1s.
     */

    public int maximalSquare(char[][] matrix)
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<dp.length;i++)
            for(int j=1;j<dp[0].length;j++)
                if(matrix[i-1][j-1]=='1')
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;

        int res=0;
        for(int i=1;i<dp.length;i++)
            for(int j=1;j<dp[0].length;j++)
                res=Math.max(res,dp[i][j]);

        return res*res;
    }

}
