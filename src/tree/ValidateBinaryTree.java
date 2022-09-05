package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTree {

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

    public boolean solution(TreeNode root) {
        return DFSUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean DFSUtil(TreeNode root, int left, int right) {
        if(root==null) {
            return true;
        }
        if(left>=root.val && root.val>=right) {
            return false;
        }
        return DFSUtil(root.left, left, root.val) && DFSUtil(root.right, root.val, right);
    }

    public static void main(String[] args) {
        ValidateBinaryTree validateBinaryTree = new ValidateBinaryTree();
        int[] nums = {3,5,1,6,2,0,8,-1,-1,7,4};
        TreeNode root = validateBinaryTree.addNode(nums);

    }
}
