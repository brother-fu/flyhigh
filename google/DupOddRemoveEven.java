/* this are for interview questions*/
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=168618&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311

import java.io.*;
import java.util.*;
public class DupOddRemoveEven {
	public void do (int[] num) {
	    int i = 0, j = 1, count = 0;
	    while (j < num.length) {
	    	if (num[i] % 2 == 1) {
	    	   // odd, find an even for i + 1;
               while (j < nums.length && nums[j] % 2 == 1) {
               	   j++;
               	   if (j == nums.length) break;
               }
               swap(nums, i + 1, j);
               nums[i + 1] = nums[i];
               i += 2;
	    	} else {
	    		// i even, find an odd for i;
	    		
	    	}
	    }
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}