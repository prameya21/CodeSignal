class ListNode
{
    int val;
    ListNode next;
    public ListNode(int val)
    {
        this.val=val;
        next=null;
    }
}
public class ReverseNodesInKGroups
{
    /*
    Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to the length of l.
    If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.

    You may not alter the values in the nodes - only the nodes themselves can be changed.

    Example

    For l = [1, 2, 3, 4, 5] and k = 2, the output should be
    reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5];
    For l = [1, 2, 3, 4, 5] and k = 1, the output should be
    reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5];
    For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
    reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].

    Input/Output

    [execution time limit] 3 seconds (java)

    [input] linkedlist.integer l

    A singly linked list of integers.

    Guaranteed constraints:
    1 ≤ list size ≤ 104,
    -109 ≤ element value ≤ 109.

    [input] integer k

    The size of the groups of nodes that need to be reversed.

    Guaranteed constraints:
    1 ≤ k ≤ l size.

    [output] linkedlist.integer
    The initial list, with reversed groups of k elements.

     */


    ListNode reverseNodesInKGroups(ListNode head, int k)
    {
        if(head==null)
            return null;
        ListNode node=head;
        int i=0;
        while(i<k && node!=null)
        {
            node=node.next;
            i++;
        }
        if(i==k)
        {
            node=reverseNodesInKGroups(node,k);
            while(i>0)
            {
                ListNode next=head.next;
                head.next=node;
                node=head;
                head=next;
                i--;
            }
            return node;
        }
        return head;
    }

    public static void main(String[] args)
    {

        ReverseNodesInKGroups obj=new ReverseNodesInKGroups();

        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        ListNode rev=obj.reverseNodesInKGroups(head,2);
        while(rev!=null)
        {
            System.out.println(rev.val);
            rev=rev.next;
        }
    }
}
