/*http://www.1point3acres.com/bbs/thread-186745-1-1.html*/

import java.util.*;
import java.io.*;

public class FriendMatrix {
    
    public int getCircle(int[][] relations) {
    	if (relations == null || relations.length == 0)
            return 0;
        int n = relations.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
        	parent[i] = i;
        for (int i = 0; i < n; i++) {
        	for (int j = i + 1; j < n; j++) {
        		if (relations[i][j] == 1) {
        			int p1 = findParent(parent, i);
        			int p2 = findParent(parent, j);
        			if (p1 != p2) {
        				parent[p2] = p1;
        			}
        		}
        	}
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
        	if (parent[i] == i)
        		count++;
        }
        System.out.println("count:  " + count);
        return count;
    }
    private int findParent(int[] parent, int p) {
    	while (p != parent[p])
    		p = parent[p];
        return p;
    }


	public static void main(String[] args) {
        FriendMatrix test = new FriendMatrix();
        test.getCircle(new int[][] {{0, 1, 0},{1, 0, 0},{0, 0, 0}});
        test.getCircle(new int[][] {{0, 1, 0},{1, 0, 1},{0, 1, 0}});       
	}
}
