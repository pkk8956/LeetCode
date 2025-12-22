package Stack;

import java.util.Stack;

public class LC_71 {

    //Simplify Path

    /*You are given an absolute path for a Unix-style file system, which 
    always begins with a slash '/'. Your task is to transform this absolute 
    ath into its simplified canonical path.
    The rules of a Unix-style file system are as follows:
        -- A single period '.' represents the current directory.
        -- A double period '..' represents the previous/parent directory.
        -- Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
        -- Any sequence of periods that does not match the rules above should be 
        treated as a valid directory or file name. For example, '...' and '....' are 
        valid directory or file names.
    The simplified canonical path should follow these rules:
        -- The path must start with a single slash '/'.
        -- Directories within the path must be separated by exactly one slash '/'.
        -- The path must not end with a slash '/', unless it is the root directory.
        -- The path must not have any single or double periods ('.' and '..') used 
        to denote current or parent directories.
    Return the simplified canonical path.*/

    public static void main(String[] args) {
        LC_71 obj = new LC_71();
        String path = "/home/user/Documents/../Pictures";
        System.out.println(obj.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); 
            } else {
                stack.push(part); 
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) sb.append("/").append(dir);
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
