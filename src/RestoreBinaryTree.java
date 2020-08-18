import java.util.HashMap;
import java.util.Map;

public class RestoreBinaryTree
{
    /*
    Note: Your solution should have O(inorder.length) time complexity, since this is what you will be asked to accomplish in an interview.

    Let's define inorder and preorder traversals of a binary tree as follows:

    Inorder traversal first visits the left subtree, then the root, then its right subtree;
    Preorder traversal first visits the root, then its left subtree, then its right subtree.
    For example, if tree looks like this:

        1
       / \
      2   3
     /   / \
    4   5   6
    then the traversals will be as follows:

    Inorder traversal: [4, 2, 1, 5, 3, 6]
    Preorder traversal: [1, 2, 4, 3, 5, 6]
    Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it.

    Example

    For inorder = [4, 2, 1, 5, 3, 6] and preorder = [1, 2, 4, 3, 5, 6], the output should be
    restoreBinaryTree(inorder, preorder) = {
        "value": 1,
        "left": {
            "value": 2,
            "left": {
                "value": 4,
                "left": null,
                "right": null
            },
            "right": null
        },
        "right": {
            "value": 3,
            "left": {
                "value": 5,
                "left": null,
                "right": null
            },
            "right": {
                "value": 6,
                "left": null,
                "right": null
            }
        }
    }
    For inorder = [2, 5] and preorder = [5, 2], the output should be
    restoreBinaryTree(inorder, preorder) = {
        "value": 5,
        "left": {
            "value": 2,
            "left": null,
            "right": null
        },
        "right": null
    }
     */


    TreeNode restoreBinaryTree(int[] inorder, int[] preorder)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(map,inorder, 0, inorder.length-1, preorder,0,preorder.length-1);
    }

    public TreeNode helper(Map<Integer,Integer> map, int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd)
    {
        if(inStart>inEnd || preStart>preEnd)
            return null;
        int val=preOrder[preStart];
        TreeNode root=new TreeNode(val);
        int leftSize=map.get(val)-inStart;
        root.left=helper(map,inOrder,inStart,inStart+leftSize-1,preOrder,preStart+1,preStart+leftSize);
        root.right=helper(map,inOrder,inStart+leftSize+1,inEnd,preOrder,preStart+leftSize+1,preEnd);
        return root;
    }
    public static void main(String[] args)
    {
        int[] inOrder={4,2,1,5,3,6};
        int[] preOrder={1,2,4,3,5,6};
        RestoreBinaryTree obj=new RestoreBinaryTree();
        System.out.println(obj.restoreBinaryTree(inOrder,preOrder));
    }
}
