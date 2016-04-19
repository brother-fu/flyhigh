import java.util.*;
import java.io.*;

public class Max2Product {
    public int max (int[] nums) {
        int fLarge, sLarge;
        fLarge = sLarge = Integer.MIN_VALUE;
        int fSmall, sSmall;
        fSmall = sSmall = Integer.MAX_VALUE;
        for (int num : nums) {
        	if (num > fLarge) {
        		sLarge = fLarge;
        		fLarge = num;
        	} else if (num > sLarge) {
        		sLarge = num;
        	} 

        	if (num < fSmall) {
        		sSmall = fSmall;
        		fSmall = num;
        	} else if (num < sSmall) {
        		sSmall = num;
        	}
        }
        int ret = Integer.MIN_VALUE;
        if (fSmall >= 0)
        	return fLarge * sLarge;
        if (fLarge <= 0) 
        	return fSmall * sSmall;
        if (fSmall <= 0 && fLarge >= 0) {
        	return Math.max(fSmall * sSmall, fLarge * sLarge);
        }
        return -100;
    }
	public static void main(String[] args) {
		Max2Product test = new Max2Product();
		System.out.println(test.max(new int[]{1, 2 ,3, 4}));
		System.out.println(test.max(new int[]{-5, -4, 2, 3}));
		System.out.println(test.max(new int[]{-5, 0, 2}));
	}
} 