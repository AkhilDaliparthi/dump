package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

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

    public int solution(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) {
            q.add(root);
        }
        while(!q.isEmpty()) {
            depth++;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                if(node.left!=null) {
                    temp.add(node.left);
                }
                if(node.right!=null) {
                    temp.add(node.right);
                }
            }
            q = temp;
        }
        return depth;
    }

    public int recSolution(TreeNode root) {
        return maxHeight(root);
    }

    public int maxHeight(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.recSolution(maxDepth.addNode(new int[]{3,9,20,-1,-1,15,7})));
    }
}
