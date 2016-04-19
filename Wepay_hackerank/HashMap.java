import java.io.*;
import java.util.*;

public class MyHashtable<K, V> {    
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>()).run();
    }
    private int capacity;
    private K[] keys;
    private V[] values;
    
    public MyHashtable (int capacity) {
    }
    public void put(K key, V value) {
        // TODO implement
    }

    public V get(K key) {
        // TODO implement
        return null;
    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}