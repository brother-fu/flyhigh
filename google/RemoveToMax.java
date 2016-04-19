import java.util.*;
import java.io.*;

public class RemoveToMax {
    public int getMax(int x) {
    	if (x < 1 || x > 1000000000)
    		return 0; /*再确定下这种情况下要返回什么样的值*/
        String s = String.valueOf(x);
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
        	if (s.charAt(i) == s.charAt(i + 1)) {
        		String tmp = s.substring(0, i + 1) + s.substring(i + 1);
        		int candidate = Integer.parseInt(tmp);
        		max = Math.max(max, candidate);
        	}
        }
        System.out.println(max);
        return max;
    }



	public static void main(String[] args) {
	/*http://www.1point3acres.com/bbs/thread-170992-1-1.html*/
	    RemoveToMax test = new RemoveToMax();
	    test.getMax(223336226);
	}
}
