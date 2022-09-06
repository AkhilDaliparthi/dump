package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RootToLeaf {
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

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getSum(A, res, new ArrayList<>(), 0, B);
        return res;
    }
    private void getSum(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int sum, int B) {
        if(root==null) {
            return ;
        }
        temp.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null && sum==B) {
            res.add(new ArrayList<>(temp));
        }
        getSum(root.left, res, temp, sum, B);
        getSum(root.right, res, temp, sum, B);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        RootToLeaf rootToLeaf = new RootToLeaf();
    }
}
