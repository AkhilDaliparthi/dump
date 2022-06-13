package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SubTreeOfAnotherTree {

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

    public boolean solution(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) {
            return true;
        }
        if(root==null) {
            return false;
        }
        if(isSame(root, subRoot)) {
            return true;
        }
        return solution(root.left, subRoot) || solution(root.right, subRoot);
    }


    private boolean isSame(TreeNode subHead, TreeNode subRoot) {
        if(subHead != null && subRoot != null) {
            if(subHead.val!=subRoot.val) {
                return false;
            }
        } else if (subHead==null && subRoot==null) {
            return true;
        } else {
            return false;
        }
        return isSame(subHead.left, subRoot.left) && isSame(subHead.right, subRoot.right);
    }

    public static void main(String[] args) {
        SubTreeOfAnotherTree subTreeOfAnotherTree = new SubTreeOfAnotherTree();
        TreeNode root = subTreeOfAnotherTree.addNode(new int[]{3,4,5,1,2});
        TreeNode subRoot = subTreeOfAnotherTree.addNode(new int[]{4,1,2});
        System.out.println(subTreeOfAnotherTree.solution(root, subRoot));
    }
}
