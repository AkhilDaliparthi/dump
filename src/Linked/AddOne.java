package Linked;

public class AddOne {

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
        ListNode lastNinePos = null;
        ListNode firstNinePos = null;
        ListNode curr = head;
        while(curr.next!=null) {
            if(curr.val==9) {
                if(firstNinePos==null) {
                    firstNinePos = curr;
                }
                lastNinePos = curr;
            } else {
                firstNinePos = null;
                lastNinePos = null;
            }
            curr = curr.next;
        }
        if(curr.val==9) {
            if (firstNinePos == head) {
                ListNode temp = new ListNode(1);
                temp.next = head;
                head = temp;
            } else {
                addOneAtstart(head, firstNinePos);
            }
            addZeros(firstNinePos, lastNinePos);
        }
        curr.val = (curr.val+1)%10;
        return head;
    }

    private void addOneAtstart(ListNode head, ListNode firstNinePos) {
        ListNode curr = head;
        while(curr.next != firstNinePos) {
            curr = curr.next;
        }
        curr.val = curr.val+1;
    }

    private void addZeros(ListNode start, ListNode end) {
        while (start != end) {
            start.val = 0;
            start = start.next;
        }
        end.val = 0;
    }

    public static void main(String[] args) {
        AddOne addOne = new AddOne();
        ListNode head = addOne.addNodes(new int[]{1,9,9,3});
        head = addOne.solution(head);
        while(head != null) {
            System.out.println(head.val+"\t");
            head = head.next;
        }
    }
}
