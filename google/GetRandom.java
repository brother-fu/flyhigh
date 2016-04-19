import java.io.*;
import java.util.*;
public class GetRandom {
	public static void main (String[] args){
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer, Integer> counter = new HashMap<Integer,Integer>();
		for (int i = 0; i < 11; i++)
			counter.put(i, 0);
		set.add(1);
		set.add(3);
		set.add(10);
		Random rd = new Random();
		for (int i = 0; i < 100000000; i++) {
            int t = rd.nextInt(11);
            if (!set.contains(t)) {
            	counter.put(t, counter.get(t) + 1);
            }
		}
		for (Integer key : counter.keySet())
		   System.out.println(key + ":  " + counter.get(key));
	}
}