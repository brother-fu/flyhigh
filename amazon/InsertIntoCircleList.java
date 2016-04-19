import java.io.*;
import java.util.*;

public class InsertIntoCircleList {
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode insert(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
            head.next = head;
            return head;
        } else {
            //use a tail to prevent infinite loop
            ListNode tail = head.next;
            ListNode pre = head;
            ListNode add = new ListNode (val);
            while (tail != head) {
                //System.out.println("here");
                if (pre.val <= val && val <= tail.val) {
                    pre.next = add;
                    add.next = tail;
                    add = null;
                    break;
                }
                pre = pre.next;
                tail = tail.next;
            }
            if (add != null) {
                pre.next = add;
                add.next = tail;   
            }
        }
        ListNode cur = head;
        /*
        while (cur.next != head) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        System.out.println(cur.val);
        */
        return head;
    }
    public static void main (String[] args) {
        /* case 1
        ListNode head = new ListNode(4); // oh, 是为了能够在main里面能够直接用，才定义private class为 static 的；
        ListNode tail = new ListNode(6);
        head.next = tail; tail.next = head;
        InsertIntoCircleList test = new InsertIntoCircleList();
        test.insert(head, 5);
        */
        // case 2
        ListNode head = new ListNode(4);
        head.next = head;
        InsertIntoCircleList test = new InsertIntoCircleList();
        test.insert(head, 5);
    }
}