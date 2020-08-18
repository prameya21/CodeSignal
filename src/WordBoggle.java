import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordBoggle
{
    /*
    Boggle is a popular word game in which players attempt to find words in sequences of adjacent letters on a rectangular board.

    Given a two-dimensional array board that represents the character cells of the Boggle board and an array of unique strings words, find all the possible words from words that can be formed on the board.

    Note that in Boggle when you're finding a word, you can move from a cell to any of its 8 neighbors, but you can't use the same cell twice in one word.

    Example

    For

    board = [
        ['R', 'L', 'D'],
        ['U', 'O', 'E'],
        ['C', 'S', 'O']
    ]
    and words = ["CODE", "SOLO", "RULES", "COOL"], the output should be
    wordBoggle(board, words) = ["CODE", "RULES"].
     */

    class TrieNode
    {
        TrieNode[] next=new TrieNode[26];
        String word=null;
    }

    public void insert(String word, TrieNode root)
    {
        for(char c:word.toCharArray())
        {
            if(root.next[c-'A']==null)
                root.next[c-'A']=new TrieNode();
            root=root.next[c-'A'];
        }
        root.word=word;
    }

    String[] wordBoggle(char[][] board, String[] words)
    {
        TrieNode root=new TrieNode();
        for(String w:words)
            insert(w,root);
        List<String> result=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                char c=board[i][j];
                if(root.next[c-'A']!=null)
                    dfs(root,i,j,result,board);
            }
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    public void dfs(TrieNode root, int i, int j, List<String> result, char[][] board)
    {
        if(root.word!=null)
        {
            result.add(root.word);
            root.word=null;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;
        char c=board[i][j];
        if(c=='#' || root.next[c-'A']==null)
            return;
        board[i][j]='#';
        root=root.next[c-'A'];
        dfs(root,i+1,j,result,board);
        dfs(root,i-1,j,result,board);
        dfs(root,i,j+1,result,board);
        dfs(root,i,j-1,result,board);
        dfs(root,i-1,j-1,result,board);
        dfs(root,i-1,j+1,result,board);
        dfs(root,i+1,j-1,result,board);
        dfs(root,i+1,j+1,result,board);
        board[i][j]=c;
    }


    public static void main(String[] args)
    {
        WordBoggle obj=new WordBoggle();
        System.out.println(obj.wordBoggle(new char[][]{{'R', 'L', 'D'},{'U', 'O', 'E'},{'C', 'S', 'O'}},new String[]{"CODE", "SOLO", "RULES", "COOL"}));
    }
}
