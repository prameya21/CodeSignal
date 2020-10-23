public class FillingBlocks
{
    /*

        You have a block with the dimensions 4 × n. Find the number of different ways you can fill this block with smaller blocks that have the dimensions 1 × 2. You are allowed to rotate the smaller blocks.

        Example

        For n = 1, the output should be
        fillingBlocks(n) = 1.

        There is only one possible way to arrange the smaller 1 × 2 blocks inside the 4 × 1 block.

        For n = 4, the output should be
        fillingBlocks(n) = 36.
     */

    public int fillingBlocks(int n)
    {
        switch (n) {
            case 0:
            case 1: return n;
            case 2: return 5;
            case 3: return 11;
            case 4: return 36;
        }
        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 5;
        a[3] = 11;
        a[4] = 36;
        for (int i = 5; i <= n; i++) {
            a[i] = a[i-1] + 5*a[i-2] + a[i-3] - a[i-4];
        }
        return a[n];
    }

    public static void main(String[] args)
    {
        FillingBlocks obj=new FillingBlocks();
        System.out.println(obj.fillingBlocks(2));
    }

}
