import java.io.*;
import java.util.*;

public class FlipTheBits {
    public int max(int[] nums) {
	    int i = 0, j = 0;
	    int count = 0, max = Integer.MIN_VALUE;
	    int ones = 0;
	    for (int t = 0; t < nums.length; t++) {
		    if (nums[t] == 1)
			    ones++;
	    }
	    while (j < nums.length) {
		    if (count < 0) {
			    count = 0;
			    j++;
			    continue;
		    }
            if (nums[j] == 0) {
        	    count++;
        	    max = Math.max(max, count);
            } else {
        	    count--;
            }
            j++;
	    }
	    return ones + max;
    }    

    public static void main(String[] args){
        int[] nums = 
    }
}