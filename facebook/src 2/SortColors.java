import java.util.Arrays;

/**
 * Created by Christina on 2/19/16.
 */
public class SortColors {
    //O(n), O(n)
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (left < nums.length - 1 && right > 0 && mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 2) {
                swap(nums, right--, mid);
            } else {
                mid++;
            }
        }
        return;
    }
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }


    //there are k types
    //O(n + k)
    public void sortKColors(int[] nums, int k) {
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < k; i++) {
            Arrays.fill(nums, 0, idx + count[i], i);
            idx += count[i];
        }
    }




    //there are k types
    //quick sort
    public void QS(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int j = partition(nums, start, end);
        QS(nums, start, j - 1);
        QS(nums, j + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        while(start < end) {
            if(nums[start] >= nums[start + 1]) {
                swap(nums, start, start + 1);
                start++;
            } else {
                swap(nums, start + 1, end);
                end--;
            }
        }
        return start;
    }


    public static void main(String[] arg) {
        SortColors a = new SortColors();
        a.sortColors(new int[]{0, 1, 2});
    }
}
