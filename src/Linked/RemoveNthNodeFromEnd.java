package Linked;

import java.util.List;

public class RemoveNthNodeFromEnd {

    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addNodes(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode start = head;
        for(int i=1; i<nums.length ; i++) {
            ListNode temp = new ListNode(nums[i]);
            head.next = temp;
            head = head.next;
        }
        return start;
    }

    public ListNode solution(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        if(size==n) {
            return head.next;
        }
        removeNthNode(null, head,size, n);
        return head;
    }

    private void removeNthNode(ListNode prev, ListNode curr,int size, int n) {
        if(curr != null) {
            removeNthNode(curr, curr.next, size-1, n);
        }
        if(size==n) {
            prev.next = curr.next;
            curr.next = null;
            return;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode head = removeNthNodeFromEnd.solution(removeNthNodeFromEnd.addNodes(new int[]{1,2}), 2);
        while(head != null) {
            System.out.println(head.val+"\t");
            head = head.next;
        }
    }
}
