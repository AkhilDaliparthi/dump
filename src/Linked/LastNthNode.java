package Linked;

public class LastNthNode {

    int size;

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

    int count;
    public int getNthFromLast(ListNode head, int n) {
        if (head == null)
            return -1;
        int data = getNthFromLast(head.next, n);
        count++;
        if (count == n) {
            return head.val;
        }
        return data;
    }

    public static void main(String[] args) {
        LastNthNode lastNthNode = new LastNthNode();
        ListNode head = lastNthNode.addNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(lastNthNode.getNthFromLast(head, 2));
    }
}
