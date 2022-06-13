package Linked;

public class ReorderList {

    
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

    public ListNode solution(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        ListNode end = reverse(slow);
        while(fast != null && end != null) {
            ListNode temp1 = fast.next != end ? fast.next : null;
            ListNode temp2 = end.next;
            fast.next = end;
            end.next = temp1;
            fast = temp1;
            end = temp2;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode res = reorderList.solution(reorderList.addNodes(new int[]{1,2,3,4,5}));
        while(res != null) {
            System.out.println(res.val+"\t");
            res = res.next;
        }
    }
}
