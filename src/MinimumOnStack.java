import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumOnStack
{
    /*
    Note: Write a solution with O(operations.length) complexity, since this is what you would be asked to do during a real interview.

    Implement a modified stack that, in addition to using push and pop operations, allows you to find the current minimum element in the stack by using a min operation.

    Example

    For operations = ["push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"], the output should be
    minimumOnStack(operations) = [10, 5, 5, 5, 10].

    The operations array contains 5 instances of the min operation. The results array contains 5 numbers, each representing the minimum element in the stack at the moment when min was called.
     */
    class MyStack
    {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> minStack=new Stack<>();

        public void push(int val)
        {
            st.push(val);
            if(minStack.isEmpty())
                minStack.push(val);
            else
                minStack.push(Math.min(minStack.peek(),val));

        }
        public int min()
        {
            return minStack.peek();
        }
        public void pop()
        {
            if(!st.isEmpty())
                st.pop();
            if(!minStack.isEmpty())
                minStack.pop();
        }
    }
    public int[] minimumOnStack(String[] operations)
    {
        MyStack st=new MyStack();
        List<Integer> ret=new ArrayList<>();
        for(String str:operations)
        {
            if(str.equals("min"))
                ret.add(st.min());
            else if(str.equals("pop"))
                st.pop();
            else
            {
                String data=str.split(" ")[1];
                int val=Integer.parseInt(data);
                st.push(val);
            }
        }
        int[] result=new int[ret.size()];
        for(int i=0;i<ret.size();i++)
            result[i]=ret.get(i);
        return result;
    }

    public static void main(String[] args)
    {
        MinimumOnStack obj=new MinimumOnStack();
        String[] op={"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"};
        int[] ret=obj.minimumOnStack(op);
        for(int i:ret)
            System.out.println(i);
    }

}
