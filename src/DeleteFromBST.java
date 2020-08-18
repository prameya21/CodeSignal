public class DeleteFromBST
{
    /*
    A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and the right subtrees must also be binary search trees.
    Removing a value x from a BST t is done in the following way:

    If there is no x in t, nothing happens;
    Otherwise, let t' be a subtree of t such that t'.value = x.
    If t' has a left subtree, remove the rightmost node from it and put it at the root of t';
    Otherwise, remove the root of t' and its right subtree becomes the new t's root.
    For example, removing 4 from the following tree has no effect because there is no such value in the tree:

        5
       / \
      2   6
     / \   \
    1   3   8
           /
          7
    Removing 5 causes 3 (the rightmost node in left subtree) to move to the root:

        3
       / \
      2   6
     /     \
    1       8
           /
          7
    And removing 6 after that creates the following tree:

        3
       / \
      2   8
     /   /
    1   7
    You're given a binary search tree t and an array of numbers queries. Your task is to remove queries[0], queries[1], e
     */

    public TreeNode deleteFromBST(TreeNode t, int[] queries)
    {
        for(int i:queries)
            t=deleteFromBST(t,i);
        return t;
    }

    public TreeNode deleteFromBST(TreeNode root, int val)
    {
        if(root==null)
            return null;
        else if(root.val<val)
            root.right=deleteFromBST(root.right,val);
        else if(root.val>val)
            root.left=deleteFromBST(root.left,val);
        else if(root.val==val)
            root=helper(root,val);
        return root;
    }

    public TreeNode helper(TreeNode root, int val)
    {
        if(root.left==null && root.right==null)
            return null;
        else if(root.left!=null)
        {
            int rightMost=getRightMost(root.left);
            root.val=rightMost;
            return root;
        }
        else
        {
            root.val=root.right.val;
            root.left=root.right.left;
            root.right=root.right.right;
            return root;
        }
    }

    public int getRightMost(TreeNode root)
    {
        if(root.right==null)
        {
            int val=root.val;
            root.val=root.left.val;
            root.left.left=root.left;
            return val;
        }
        int val=root.val;
        while(root.right!=null)
        {
            if(root.right.right==null)
            {
                val=root.right.val;
                root.right=root.right.left;
                break;
            }
            else
                root=root.right;
        }
        return val;
    }

    public static void main(String[] args)
    {
        DeleteFromBST obj=new DeleteFromBST();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right=new TreeNode(6);
        root.right.right=new TreeNode(8);
        root.right.right.left=new TreeNode(7);

        TreeNode root2=new TreeNode(3);
        root2.left=new TreeNode(2);
        System.out.println(obj.deleteFromBST(root2,new int[]{1,2,3,5}));
    }
}
