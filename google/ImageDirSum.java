import java.util.*;
import java.io.*;

public class ImageDirSum {
	private class Node {
		int leadingspace;
		String dir;
		public Node(int leadingspace, String dir) {
			this.leadingspace = leadingspace;
			this.dir = dir;
		}
	}
    public int getSum (String s) {
    	String[] dirs = s.split("\n");
    	Stack<Node> stack = new Stack<Node>();   //keep track of  directory hierarchy
    	Set<Node> explored = new HashSet<Node>();  
    	int len = 0, sum = 0;
    	for (String dir : dirs) {
    		int j = 0;
            while (dir.charAt(j) == ' ') {
            	j++;
            }
            while (!stack.empty() && stack.peek().leadingspace >= j) {
            	Node node = stack.pop();
            	len -= node.dir.length();
            }

            if (!dir.contains(".")) { // is directory
            	String tmpdir = dir.trim();
                stack.push(new Node(j, tmpdir));
                len += tmpdir.length();
            } else { // is a file
            	if (dir.contains(".jpeg") || dir.contains(".png") || dir.contains(".gif")) {
            		Node outerscope = stack.empty() ? null : stack.peek();
            		if (explored.add(outerscope)) {
            			int path = len + stack.size();
            			if (path == 0) path = 1;  // in root 
                        sum += path;
                    }
            	}
            }
    	}
    	System.out.println("total directory sum is: " + sum);
    	return sum;
    }



    public static void main(String[] args) {
	    ImageDirSum test = new ImageDirSum();
	    //test.getSum("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif");
	    //test.getSum("dir1\n dir11\n dir12\n  picture.jpeg\n  ppmm.png\n  dir121\n  file1.txt\ndir2\n file2.gif");
	    test.getSum("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n   my.png\n  file1.txt\ndir2\n file2.gif\nname.gif");
	    test.getSum("dir1\n dir11\n dir12\n  picture.jppeg\n  dir121\n  file1.txt\ndir2\n file2.giif\nname.gitf");
/*http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=170339&highlight=google%2Boa*/
	}
}

//两种形式， 求绝对路径最长 ／ 总和