import java.util.*;
import java.io.*;

public class MaxDir {
	private class Node {
		int leadingspace;
		String dir;
		public Node(int leadingspace, String dir) {
			this.leadingspace = leadingspace;
			this.dir = dir;
		}
	}
    public int getMax (String s) {
    	//Get the total length of all the directary containing pictures;
    	String[] dirs = s.split("\n");
    	Stack<Node> stack = new Stack<Node>();   //keep tracks directory hierarchy
        int max = 0, len = 0;
    	for (String dir : dirs) {
    		int j = 0;
            while (dir.charAt(j) == ' ') {
            	j++;
            }
            while (!stack.empty() && stack.peek().leadingspace >= j) {
            	Node node = stack.pop();
            	len -= node.dir.length();
            }

            if (!dir.contains(".")) { // is Directory
            	String tmpdir = dir.trim();
                stack.push(new Node(j, tmpdir));
                len += tmpdir.length();
            } else { // is a file
            	if (dir.contains(".jpeg") || dir.contains(".png") || dir.contains(".gif")) {
            		int path = len + stack.size() + 1 + dir.trim().length();
                    max = Math.max(max, path);
            	}
            }
    	}
    	System.out.println("longest path length is: " + max);
        //System.out.println("count test: " + "/dir/ddir/b.jpeg".length());
    	return max;
    }



    public static void main(String[] args) {
	    MaxDir test = new MaxDir();
	    test.getMax("dir1\n dir11\n dir12\n  picture.jpjeg\n  dir121\n  file1.txt\ndir2\n file2.gijf\nname.gjif");
        test.getMax("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif\nname.gif");

	}
}

//两种形式， 求绝对路径最长 ／ 总和