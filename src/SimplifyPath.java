import java.util.Stack;

public class SimplifyPath
{
    /*
        Given an absolute file path (Unix-style), shorten it to the format /<dir1>/<dir2>/<dir3>/....

        Here is some info on Unix file system paths:

        / is the root directory; the path should always start with it even if it isn't there in the given path;
        / is also used as a directory separator; for example, /code/fights denotes a fights subfolder in the code folder in the root directory;
        this also means that // stands for "change the current directory to the current directory"
        . is used to mark the current directory;
        .. is used to mark the parent directory; if the current directory is root already, .. does nothing.
        Example

        For path = "/home/a/./x/../b//c/", the output should be
        simplifyPath(path) = "/home/a/b/c".

        Here is how this path was simplified:
        * /./ means "move to the current directory" and can be replaced with a single /;
        * /x/../ means "move into directory x and then return back to the parent directory", so it can replaced with a single /;
        * // means "move to the current directory" and can be replaced with a single /.
     */

    public String simplifyPath(String path)
    {
        if(path==null || path.length()==0)
            return "/";
        String[] dirs=path.split("/");
        Stack<String> st=new Stack<>();
        for(String dir:dirs)
        {
            if(dir.equals(".") || dir.equals(""))
                continue;
            if(dir.equals(".."))
            {
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(dir);

        }
        StringBuilder sb=new StringBuilder();
        sb.append("/");
        for(String dir:st)
            sb.append(dir).append("/");
        sb.setLength(sb.length()==1?sb.length():sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args)
    {
        String path="/home/a/./x/../b//c/";
        SimplifyPath obj=new SimplifyPath();
        System.out.println(obj.simplifyPath(path));
    }



}
