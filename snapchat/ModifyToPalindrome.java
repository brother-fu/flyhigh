/*http://www.1point3acres.com/bbs/thread-179863-1-1.html*/
import java.util.*;
import java.io.*;

public class ModifyToPalindrome {
    
    public int getstep(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int add = s.charAt(i) == s.charAt(i + l - 1) ? 0 : 1;
                dp[i][i + l - 1] = Math.min(dp[i + 1][i + l - 1], dp[i][i + l - 2]) + 1;
                dp[i][i + l - 1] = Math.min(dp[i][i + l - 1], dp[i + 1][i + l - 2] + add);
            }
        }
        System.out.println("steps to palindrome:  " + dp[0][len - 1]);
        return dp[0][len - 1];
    }



	public static void main(String[] args) {
        ModifyToPalindrome mtp = new ModifyToPalindrome();
        mtp.getstep("ebabc");
        mtp.getstep("acbeffebc");
	}
}
