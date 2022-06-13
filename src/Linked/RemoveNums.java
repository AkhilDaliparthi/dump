package Linked;

public class RemoveNums {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        while (curr != null && curr.val == val) {
            curr = curr.next;
        }
        ListNode start = curr;
        ListNode prev = null;
        ListNode temp;
        while(curr != null) {
            temp = curr.next;
            boolean isNodeDeleted = false;
            if(curr.val == val) {
                if(prev != null) {
                    prev.next = curr.next;
                }
                isNodeDeleted = true;
            }
            if(!isNodeDeleted) {
                prev = curr;
            }
            curr = temp;
        }
        return start;
    }

    public static void main(String[] args) {
        RemoveNums removeNums = new RemoveNums();
        int[] nums = {2,2,1,8,2,3,2,7,2};
        ListNode head = removeNums.addNodes(nums);
        System.out.println(removeNums.removeElements(head, 2));
    }
}
