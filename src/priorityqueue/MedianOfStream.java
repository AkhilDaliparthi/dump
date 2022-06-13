package priorityqueue;

public class MedianOfStream {

    int len;
    int left;
    int right;
    Node mid;

    public class Node{
        int val;
        Node next;
        Node prev;
        Node() {}
        Node(int val) {
            this.val = val;
        }
    }

    public void solution(int i) {
        Node curr = new Node(i);
        len++;
        if(len == 1) {
            mid = curr;
        } else {
            if(i==mid.val) {
                if(len == 2) {
                    mid.next = curr;
                    curr.prev = mid;
                } else {
                    Node temp = mid.next;
                    temp.prev = curr;
                    mid.next = curr;
                    curr.prev = mid;
                    curr.next = temp;
                }
                right++;
            }
            else if(i<mid.val) {
                left++;
                addLeft(mid, i);
            } else {
                right++;
                addRight(mid, i);
            }
            if(left>right && left-right>0) {
                mid = mid.prev;
                right++;
                left--;
            }
            if(right>left && right-left>1) {
                    mid = mid.next;
                    left++;
                    right--;
            }
        }
        if(len%2==1) {
            System.out.println(mid.val);
        } else {
            System.out.println(mid.val*0.5+mid.next.val*0.5);
        }
    }

    public void addLeft(Node curr, int i) {
        Node start = curr;
        Node temp = new Node(i);
        while(start.prev !=null && start.prev.val>i) {
            start = start.prev;
        }
        if(start.prev != null) {
            Node prev = start.prev;
            prev.next = temp;
            temp.prev = prev;
            temp.next = start;
            start.prev = temp;
        } else {
            start.prev = temp;
            temp.next = start;
        }
    }

    public void addRight(Node curr, int i) {
        Node start = curr;
        Node temp = new Node(i);
        while(start.next!=null && start.next.val<i) {
            start = start.next;
        }
        if(start.next != null) {
            Node next = start.next;
            next.prev = temp;
            temp.next = next;
            temp.prev = start;
            start.next = temp;
        } else {
            start.next = temp;
            temp.prev = start;
        }
    }

    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.solution(6);
        medianOfStream.solution(10);
        medianOfStream.solution(2);
        medianOfStream.solution(6);
        medianOfStream.solution(5);
        medianOfStream.solution(0);
        medianOfStream.solution(6);
        medianOfStream.solution(3);
        medianOfStream.solution(1);
        medianOfStream.solution(0);
        medianOfStream.solution(0);
    }
}
