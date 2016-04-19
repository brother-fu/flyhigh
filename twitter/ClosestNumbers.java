import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClosestNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();  //注意close我
        Arrays.sort(nums);   
        
        //keep track of the Minimum pair
        long min = Integer.MAX_VALUE;
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < nums.length - 1; i++) {
            long tmp = (long)nums[i + 1] - nums[i];
            if (tmp <= min) {
                if (tmp < min) {
                    min = tmp;
                    candidates.clear();
                }
                candidates.add(nums[i]);
                candidates.add(nums[i + 1]);
            }
        }
        for (int i = 0; i < candidates.size(); i++) {
            System.out.print(candidates.get(i));
            if (i != candidates.size() - 1)
                System.out.print(' ');
        }
    }
}