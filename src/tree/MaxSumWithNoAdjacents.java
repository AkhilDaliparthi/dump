package tree;

import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumWithNoAdjacents {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode addNode(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int i = 0;
        while(!que.isEmpty() && i<nums.length) {
            TreeNode peek = que.peek();
            que.remove();
            if(i+1<nums.length && nums[++i] != -1) {
                peek.left = new TreeNode(nums[i]);
                que.add(peek.left);
            }
            if(i+1<nums.length && nums[++i] != -1) {
                peek.right = new TreeNode(nums[i]);
                que.add(peek.right);
            }
        }
        return root;
    }

    public Pair<Integer, Integer> solution (TreeNode root) {
        if(root==null) {
           return new Pair(0,0);
        }
        Pair<Integer, Integer> left = solution(root.left);
        Pair<Integer, Integer> right = solution(root.right);
        int inc = root.val+left.snd+right.snd;
        int ex = Math.max(left.fst, left.snd) + Math.max(right.fst, right.snd);
        return new Pair(inc, ex);
    }

    public static void main(String[] args) {
        MaxSumWithNoAdjacents maxSumWithNoAdjacents = new MaxSumWithNoAdjacents();
        int[] nums = {-10,9,20,-1,-1,15,7};
        TreeNode root = maxSumWithNoAdjacents.addNode(nums);
        System.out.println(maxSumWithNoAdjacents.solution(root));
    }
}
