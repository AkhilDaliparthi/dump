package Linked;

public class RemoveDuplicates {
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

    public ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;
        if(curr == null || curr.next == null) {
            return curr;
        }
        while(curr != null) {
            ListNode nextNode = curr.next;
            while(nextNode != null && curr.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            curr.next = nextNode;
            curr = curr.next;
        }
    
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1,1};
        ListNode head = removeDuplicates.addNodes(nums);
        System.out.println(removeDuplicates.removeDuplicates(head));
    }
}
