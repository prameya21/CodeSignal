import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SwapLexOrderUF
{
    /*
    Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicogically largest string that results from doing the allowed swaps. You can swap indices any number of times.

    Example

    For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
    swapLexOrder(str, pairs) = "dbca".

    By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicogically largest string in this list is "dbca".
     */


    public int find(int[] roots, int i)
    {
        if(roots[i]!=i)
            roots[i]=find(roots,roots[i]);
        return roots[i];
    }
    public void union(int[] roots, int i, int j)
    {
        int ri=find(roots,i), rj=find(roots,j);
        roots[rj]=ri;
    }
    public String swapLexOrder(String str, int[][] pairs)
    {
        int[] roots=new int[str.length()];
        for(int i=0;i<roots.length;i++)
            roots[i]=i;

        for(int[] i:pairs)
            union(roots,i[0]-1,i[1]-1);

        Map<Integer, PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<roots.length;i++)
        {
            int idx=find(roots,i);
            map.putIfAbsent(idx,new PriorityQueue<Character>(Collections.reverseOrder()));
            map.get(idx).offer(str.charAt(i));
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<roots.length;i++)
        {
            sb.append(map.get(roots[i]).poll());
        }
        return sb.toString();
    }



    public static void main(String[] args)
    {
        SwapLexOrderUF obj=new SwapLexOrderUF();
        //System.out.println(obj.swapLexOrder("abdc",new int[][]{{1,4},{3,4}}));
        //System.out.println(obj.swapLexOrder("lvvyfrbhgiyexoirhunnuejzhesylojwbyatfkrv",new int[][]{{13,23},{13,28},{15,20},{24,29},{6,7},{3,4},{21,30},{2,13},{12,15},{19,23},{10,19},{13,14},{6,16},{17,25},{6,21},{17,26},{5,6},{12,24}}));
        //System.out.println(obj.swapLexOrder("acxrabdz",new int[][]{{1,3},{6,8},{8,3},{2,7}}));
        System.out.println(obj.swapLexOrder("acxrabdz",new int[][]{{1,3},{6,8},{3,8},{2,7}}));
    }
}
