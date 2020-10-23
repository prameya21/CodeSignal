import java.util.*;
public class SquirrelAndNut
{
    /*
    Wandering in the woods, you noticed a squirrel sitting in node A of a tree. It didn't look like it was going to sit there forever though: there was a delicious nut in node B, and the squirrel looked determined to reach it by moving via the branches of the tree.
    You grabbed your camera to take a picture of the squirrel in node C (that's the only node that would make the picture perfect), but was too late: the smart rodent had already made it to node B.
    There are still a lot of nuts on the tree, and it seems that the squirrel is going to try and take them all.
    Looks like the squirrel is smart enough to follow only the shortest paths along the tree branches, which means you can now predict when the right opportunity to take a perfect picture arises.
    Given configuration of the tree and a bunch of triples consisting of numbers A, B and C, for each triple return true if the squirrel will run through node C on its path from A to B, and false otherwise.

    It is guaranteed that each node has no more than 5 branches.

    Example

    For

    tree = [1, 2,
            1, 3,
            2, 4,
            3, 5,
            3, 6]
    and

    triples = [[4, 6, 3],
               [1, 4, 2],
               [5, 6, 1]]
    the output should be
    squirrelAndNut(tree, triples) = [true, true, false].
     */

    int min;
    Set<Integer> visited;
    public boolean[] squirrelAndNut(int[] tree, int[][] triples)
    {
        if(tree==null || tree.length==0 || triples==null || triples.length==0)
            return new boolean[triples.length];
        Map<Integer,List<Integer>> graph=new HashMap<>();
        boolean[] result=new boolean[triples.length];
        for(int i=0;i<tree.length;i+=2)
        {
            int u=tree[i];
            int v=tree[i+1];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int idx=0;
        for(int[] i:triples)
        {
            min=Integer.MAX_VALUE;
            visited=new HashSet<>();
            dfs(graph,i[0],i[1],new HashSet<>());
            result[idx++]=visited.contains(i[2]);
        }
        return result;
    }
/*
    public Set<Integer> bfs(Map<Integer,List<Integer>> map, int s, int d)
    {
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        Set<Integer> ret=new HashSet<>();
        q.offer(s);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            if(curr==d)
            {
                ret.add(d);
                return ret;
            }
            if(visited.contains(curr) || !map.containsKey(curr))
                continue;
            visited.add(curr);
            ret.add(curr);
            for(int nxt:map.get(curr))
            {
                if(visited.contains(nxt))
                    continue;
                q.offer(nxt);
            }

        }
    }*/

    public void dfs(Map<Integer,List<Integer>> map,int s, int d, Set<Integer> temp)
    {
        if(!map.containsKey(s) || temp.contains(s))
            return;
        if(s==d)
        {
            if(visited==null || visited.size()==0 || temp.size()<visited.size())
            {
                visited=new HashSet<>();
                visited.addAll(temp);
            }
        }
        temp.add(s);
        for(int nxt:map.get(s))
            dfs(map,nxt,d,temp);
        temp.remove(s);
    }

    public static void main(String[] args)
    {
        SquirrelAndNut obj=new SquirrelAndNut();
        System.out.println(Arrays.toString(obj.squirrelAndNut(new int[]{1, 2, 1, 3, 2, 4, 3, 5, 3, 6},new int[][]{{4,6,3},{1,4,2},{5,6,1}})));
    }

}
