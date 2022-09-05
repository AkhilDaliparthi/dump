package Linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSorted {

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


    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int l=0;
        int r=a.size()-1;
        return merge(a, l, r);
    }
    private ListNode merge(List<ListNode> list, int l, int r) {
        if(l>r) return null;
        if(r==l) return list.get(l);

        int m = (l+r)/2;
        ListNode left = merge(list, l, m);
        ListNode right = merge(list, m+1, r);
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode runner = head;
        while(a!=null || b!=null) {
            if(a==null) {
                runner.next = b;
                b = b.next;
            }
            else if(b==null) {
                runner.next = a;
                a = a.next;
            }
            else {
                if(a.val<=b.val) {
                    runner.next = a;
                    a = a.next;
                }
                else {
                    runner.next = b;
                    b = b.next;
                }
            }
            runner = runner.next;
        }
        runner.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        MergeKSorted mergeKSorted = new MergeKSorted();
        ListNode res = mergeKSorted.mergeKLists(new ArrayList(Arrays.asList(1,2)));
    }
}
