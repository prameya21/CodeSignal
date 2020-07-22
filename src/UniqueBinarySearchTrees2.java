import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2
{
    /*
    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

    Example:

    Input: 3
    Output:
    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]
    Explanation:
    The above output corresponds to the 5 unique BST's shown below:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */
    class TreeNode
    {
        int val;
        TreeNode left=null,right=null;
        public TreeNode(int val)
        {
            this.val=val;
        }
    }
    public List<TreeNode> generateTrees(int n)
    {
        if(n==0)
            return new ArrayList<>();
        List<TreeNode> result=new ArrayList<>();
        return generate(1,n);
    }

    public List<TreeNode> generate(int s, int e)
    {
        List<TreeNode> res=new ArrayList<>();
        if(s>e)
        {
            res.add(null);
            return res;
        }
        for(int i=s;i<=e;i++)
        {
            List<TreeNode> l=generate(s,i-1);
            List<TreeNode> r=generate(i+1,e);
            for(TreeNode left:l)
            {
                for(TreeNode right:r)
                {
                    TreeNode curr=new TreeNode(i);
                    curr.left=left;
                    curr.right=right;
                    res.add(curr);
                }
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        UniqueBinarySearchTrees2 obj=new UniqueBinarySearchTrees2();
        System.out.println(obj.generateTrees(3));
    }
}
