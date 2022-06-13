package Linked;

public class LinkedListPallindrome {
    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode left;

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

    public boolean isPallindrome(ListNode head) {
        ListNode firstHalfEnd = getMiddleNode(head);
        ListNode secondHalfStart = reverse(firstHalfEnd);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while(p1 != null && p2 != null) {
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse (ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode temp;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public ListNode getMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean checkLeftRight(ListNode left, ListNode right) {
        if(right != null) {
            if(!checkLeftRight(left, right.next)) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
        }
        return true;
    }

    public boolean isPallindromeRec(ListNode head) {
        left = head;
        return checkLeftRight(left, head);
    }


    public static void main(String[] args) {
        LinkedListPallindrome listPallindrome = new LinkedListPallindrome();
        int[] nums = {1,2,2,2};
        ListNode head = listPallindrome.addNodes(nums);
        System.out.println(listPallindrome.isPallindromeRec(head));
    }
}
