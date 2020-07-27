public class ListPalindrome
{
    /*
    Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.

    Given a singly linked list of integers, determine whether or not it's a palindrome.

    Note: in examples below and tests preview linked lists are presented as arrays just for simplicity of visualization: in real data you will be given a head node l of the linked list

    Example

    For l = [0, 1, 0], the output should be
    isListPalindrome(l) = true;

    For l = [1, 2, 2, 3], the output should be
    isListPalindrome(l) = false.
     */



    public boolean isListPalindrome(ListNode l)
    {
        if(l==null)
            return true;
        ListNode fast=l,slow=l,prev=null;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;

        }
        prev.next=null;
        if(fast!=null)
            slow=slow.next;

        slow=reverse(slow);

        while(l.next!=null)
        {
            if(l.val!=slow.val)
                return false;
            l=l.next;
            slow=slow.next;
        }
        return true;


    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode nxt=head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }

    public static void main(String[] args)
    {
        ListPalindrome obj1=new ListPalindrome();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        System.out.println(obj1.isListPalindrome(head));
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(1);
        node.next.next.next.next=new ListNode(2);
        node.next.next.next.next.next=new ListNode(3);

        System.out.println(obj1.isListPalindrome(node));
    }
}
