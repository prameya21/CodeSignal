import java.util.*;

public class SwapLexOrder
{
    /*
    Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicogically largest string that results from doing the allowed swaps. You can swap indices any number of times.

    Example

    For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
    swapLexOrder(str, pairs) = "dbca".

    By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicogically largest string in this list is "dbca".
     */



    public String swapLexOrder(String str, int[][] pairs)
    {
        Map<Integer, List<Integer>> g=new HashMap<>();
        for(int[] i:pairs)
        {
            g.putIfAbsent(i[0]-1,new ArrayList<>());
            g.putIfAbsent(i[1]-1,new ArrayList<>());
            g.get(i[0]-1).add(i[1]-1);
            g.get(i[1]-1).add(i[0]-1);
        }
        Map<Integer,List<Integer>> componentList=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        int ctr=0;
        for(int i:g.keySet())
        {
            if(visited.contains(i))
                continue;
            List<Integer> members=new ArrayList<>();
            dfs(g,i,visited,members);
            Collections.sort(members);
            componentList.put(ctr,members);
            ctr++;

        }
        Map<Integer,List<Character>> charList=new HashMap<>();

        for(int i:componentList.keySet())
        {
            charList.put(i,new ArrayList<>());
            for(int j:componentList.get(i))
                charList.get(i).add(str.charAt(j));
            Collections.sort(charList.get(i),Collections.reverseOrder());
        }

        StringBuilder sb=new StringBuilder(str);
        for(int i:charList.keySet())
        {
            for(int j=0;j<charList.get(i).size();j++)
            {
                int idx=componentList.get(i).get(j);
                char ch=charList.get(i).get(j);
                sb.setCharAt(idx,ch);
            }
        }

        return sb.toString();
    }

    public void dfs(Map<Integer,List<Integer>> g, int src, Set<Integer> visited, List<Integer> elem)
    {
        if(visited.contains(src) || !g.containsKey(src))
            return;
        visited.add(src);
        elem.add(src);
        for(int i:g.get(src))
            dfs(g,i,visited,elem);

    }


    public static void main(String[] args)
    {
        SwapLexOrder obj=new SwapLexOrder();
        System.out.println(obj.swapLexOrder("abdc",new int[][]{{1,4},{3,4}}));
        //System.out.println(obj.swapLexOrder("lvvyfrbhgiyexoirhunnuejzhesylojwbyatfkrv",new int[][]{{13,23},{13,28},{15,20},{24,29},{6,7},{3,4},{21,30},{2,13},{12,15},{19,23},{10,19},{13,14},{6,16},{17,25},{6,21},{17,26},{5,6},{12,24}}));
        //System.out.println(obj.swapLexOrder("acxrabdz",new int[][]{{0,2},{5,7},{7,2},{1,6}}));
    }
}
