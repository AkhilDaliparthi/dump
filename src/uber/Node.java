package uber;

import java.util.ArrayList;
import java.util.List;

public class Node{
    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
