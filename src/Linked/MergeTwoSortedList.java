package Linked;

public class MergeTwoSortedList {

    public class ListNode{
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

    public ListNode solution(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode curr = l1;
        ListNode prev = null;
        while(curr != null && curr.val<= l2.val) {
            while(curr.val<=l2.val) {
                prev = curr;
                curr = curr.next;
            }
            ListNode temp = l2.next;
            if(prev != null) {
                prev.next = l2;
            } else {
                l1=l2;
            }
            l2.next = curr;
            prev = l2;
            l2 = temp;
        }
        if(l2!=null && prev != null) {
            prev.next = l2;
        }
        return l1;
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode l1 = mergeTwoSortedList.addNodes(new int[]{});
        ListNode l2 = mergeTwoSortedList.addNodes(new int[]{});
        ListNode res = mergeTwoSortedList.solution(l1, l2);
    }
}
