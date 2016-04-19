import java.util.*;
import java.io.*;

public class GapChar {
    public String gapChar (String s) {
        char[] sc = s.toCharArray();
        int len = sc.length;
        Arrays.sort(sc);
        char[] aux = new char[len];
        int i = 0, k = 0,  j = len / 2;
        if (len % 2 != 0)
            j++;
        for (k = 0; k < len; k++) {
            if (k % 2 == 0) 
                aux[k] = sc[i++];
            else
                aux[k] = sc[j++];
        }
        String tmp = String.valueOf(aux);
        System.out.println("result:   " + tmp);
        return tmp;
    }
    



	public static void main(String[] args) {
        GapChar test = new GapChar();
        String s = "abcdaa";
        test.gapChar(s);
	}
}
