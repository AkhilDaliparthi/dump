package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinHeight {

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

    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        getDepth(A, 0);
        return min;
    }

    private void getDepth(TreeNode root, int height) {
        if(root==null) {
            return ;
        }
        if(root.left == null && root.right == null && height<min) {
            min = height;
        }
        getDepth(root.left, height+1);
        getDepth(root.right, height+1);
    }

    public static void main(String[] args) {
        MinHeight minHeight = new MinHeight();
        TreeNode root = minHeight.addNode(new int[]{1, 2, -1, -1, 3, -1, -1});
        System.out.println(minHeight.minDepth(root));
    }
}
