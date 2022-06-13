package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfTree {

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

    int max = 0;
    public int solution(TreeNode root) {
        depthOfBinaryTree(root);
        return max;
    }

    private int depthOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        if(max<(left+right)) {
            max = left+right;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        System.out.println(diameterOfTree.solution(diameterOfTree.addNode(new int[]{1,2,3,4,5})));
    }
}
