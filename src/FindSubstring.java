public class FindSubstring
{
    /*
    You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:

    If several parts substrings occur in one string in words, choose the longest one. If there is still more than one such part, then choose the one that appears first in the string.

    Example

    For words = ["Apple", "Melon", "Orange", "Watermelon"] and parts = ["a", "mel", "lon", "el", "An"], the output should be
    findSubstrings(words, parts) = ["Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"].

    While "Watermelon" contains three substrings from the parts array, "a", "mel", and "lon", "mel" is the longest substring that appears first in the string.

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.string words

    An array of strings consisting only of uppercase and lowercase English letters.

    Guaranteed constraints:
    0 ≤ words.length ≤ 104,
    1 ≤ words[i].length ≤ 30.

    [input] array.string parts

    An array of strings consisting only of uppercase and lower English letters. Each string is no more than 5 characters in length.

    Guaranteed constraints:
    0 ≤ parts.length ≤ 105,
    1 ≤ parts[i].length ≤ 5,
    parts[i] ≠ parts[j].

    [output] array.string
     */

    class Trie
    {
        Trie[] next;
        int length;
        public Trie()
        {
            next=new Trie[58];
            length=-1;
        }
    }

    public void insert(Trie root, String part)
    {
        for(char c:part.toCharArray())
        {
            if(root.next[c-'A']==null)
                root.next[c-'A']=new Trie();
            root=root.next[c-'A'];
        }
        root.length=part.length();
    }

    public int find(Trie root, int index, String word)
    {
        for(int i=index;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(root.next[c-'A']==null)
                break;
            root=root.next[c-'A'];
        }
        return root.length;
    }

    String[] findSubstrings(String[] words, String[] parts)
    {
        Trie root=new Trie();
        for(String s:parts)
            insert(root,s);

        for(int i=0;i<words.length;i++)
        {
            int idx=0,len=-1;
            String word=words[i];
            for(int j=0;j<word.length();j++)
            {
                int l=find(root,j,word);
                if(len<l)
                {
                    len=l;
                    idx=j;
                }
            }
            if(len==-1)
                continue;
            StringBuilder sb=new StringBuilder(word);
            sb.insert(idx,'[');
            sb.insert(idx+len+1,']');
            words[i]=sb.toString();
        }
        return words;
    }

    public static void main(String[] args)
    {
        FindSubstring obj=new FindSubstring();
        //String[] ret=obj.findSubstrings(new String[]{"Apple","Melon","Orange","Watermelon"},new String[]{"a","mel","lon","el","An"});
        String[] ret=obj.findSubstrings(new String[]{"Apple","Melon","Orange","Watermelon"},new String[0]);
        for(String s:ret)
            System.out.println(s);
    }
}
