package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeastCommonAncestor {

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

    private int foundCount = 0;
    public int lca(TreeNode A, int B, int C) {
        TreeNode LCA = findLCA(A, B, C);
        if(foundCount == 1 && B==C){
            return B;
        }
        if(LCA == null || foundCount < 2){
            return -1;
        }
        return LCA.val;
    }
    private TreeNode findLCA(TreeNode root, int A, int B){
        if(root == null) return null;
        TreeNode leftVal = findLCA(root.left, A, B);
        TreeNode rightVal  = findLCA(root.right, A, B);
        if(root.val == A || root.val == B){
            this.foundCount++;
            return root;
        }
        if(leftVal!=null && rightVal != null) return root;
        if(leftVal!=null) return leftVal;
        if(rightVal!=null) return rightVal;
        return null;
    }

    public static void main(String[] args) {
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        int[] nums = {3,5,1,6,2,0,8,-1,-1,7,4};
        TreeNode root = leastCommonAncestor.addNode(nums);
        System.out.println(leastCommonAncestor.lca(root, 5, 4));
    }
}
