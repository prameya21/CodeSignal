import java.util.Comparator;
import java.util.PriorityQueue;

public class OrienteeringGame
{
    /*
    Not long ago you saw an orienteering competition on TV and immediately wanted to try it yourself. You've joined an orienteering club and started preparing for the upcoming competitions.

    You've just came home from one particularly exhausting competition and decided to relax by playing a board game which all qualified participants (including you, of course) got as a reward.
    In this game your objective is to navigate your way on the board from the start located in the upper-left corner to the finish located in the bottom-right corner in as little time as possible.

    The game board is a rectangle divided into equal cells. Each cell contains a number denoting the time you should wait in this cell before advancing to the next one.
    From each cell you can move only to the neighboring one, i.e. the one directly below, above, to the left or to the right of your current position.

    Given the game board find the minimum time required to reach the finish from the start.

    Example

    For

    board = [[42, 51, 22, 10,  0 ],
             [2,  50, 7,  6,   15],
             [4,  36, 8,  30,  20],
             [0,  40, 10, 100, 1 ]]
    the output should be
    orienteeringGame(board) = 140.
     */

    public int orienteeringGame(int[][] board)
    {
        if(board==null || board.length==0)
            return 0;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] i, int[] j)
            {
                return i[2]-j[2];
            }
        });
        pq.offer(new int[]{0,0,board[0][0]});
        int cost=0;
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visited=new boolean[board.length][board[0].length];
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int i=curr[0],j=curr[1],val=curr[2];
            if(visited[i][j])
                continue;
            visited[i][j]=true;
            if(i==board.length-1 && j==board[0].length-1)
                return val-board[i][j];

            for(int[] d:dirs)
            {
                int nr=i+d[0];
                int nc=j+d[1];
                if(nr<0 || nr>=board.length || nc<0 || nc>=board[0].length || visited[nr][nc])
                    continue;
                pq.offer(new int[]{nr,nc,val+board[nr][nc]});
            }
        }
        return cost;
    }

    public static void main(String[] args)
    {
        OrienteeringGame obj=new OrienteeringGame();
        int[][] board={{42, 51, 22, 10,  0 },{2,  50, 7,  6,   15},{4,  36, 8,  30,  20},{0,  40, 10, 100, 1 }};
        System.out.println(obj.orienteeringGame(board));
    }

}
