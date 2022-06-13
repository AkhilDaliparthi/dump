package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesAtDistance {
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

    public List<Integer> solution(TreeNode root, int target, int dis) {
        List<Integer> res = new ArrayList<>();
        findAtDistance(root, target, dis, res);
        return res;
    }

    public int findAtDistance(TreeNode root, int target, int dis, List<Integer> res) {
        if(root==null) {
            return -1;
        }
        if(root.val == target) {
            getNodesAtDistance(root, dis, res);
            return 0;
        }
        int d = findAtDistance(root.left, target, dis, res);

        if(d != -1) {
            if(d+1 == dis) {
                res.add(root.val);
            } else {
                getNodesAtDistance(root.right, dis-d-2, res);
            }
            return 1+d;
        }
        d = findAtDistance(root.right, target, dis, res);
        if(d != -1) {
            if(d+1 == dis) {
                res.add(root.val);
            } else {
                getNodesAtDistance(root.left, dis-d-2, res);
            }
            return 1+d;
        }
        return -1;
    }

    private void getNodesAtDistance(TreeNode root, int dis, List<Integer> res) {
        if(root==null) {
            return;
        }
        if(dis == 0) {
            res.add(root.val);
            return;
        }
        getNodesAtDistance(root.left, dis-1, res);
        getNodesAtDistance(root.right, dis-1, res);
    }



    public static void main(String[] args) {
        NodesAtDistance nodesAtDistance = new NodesAtDistance();
        int[] nums = {3,5,1,6,2,0,8,-1,-1,7,4};
        TreeNode root = nodesAtDistance.addNode(nums);
        for(int i : nodesAtDistance.solution(root, 5, 2)) {
            System.out.println(i);
        }
    }
}
