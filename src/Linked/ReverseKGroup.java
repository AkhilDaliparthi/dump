package Linked;

public class ReverseKGroup {

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

    public ListNode solution (ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        ListNode test = current;
        int testCount = 0;
        while(test != null && testCount < k){
            test = test.next;
            testCount++;
        }

        if(testCount == k){
            while(count < k && current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if(next != null){
                head.next = solution(next,k);
            }

            return prev;
        }else
            return current;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
    }
}
