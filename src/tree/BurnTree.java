package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnTree {


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

    TreeNode leafNode = null;
    public int solve(TreeNode A, int B) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        findParents(A,map,B);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        int count = 0;
        q.add(leafNode);
        vis.add(leafNode);
        while(!q.isEmpty()){
            boolean flag = false;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();

                if(temp.left != null && !vis.contains(temp.left)){
                    flag = true;
                    q.add(temp.left);
                    vis.add(temp.left);
                }
                if(temp.right != null && !vis.contains(temp.right)){
                    q.add(temp.right);
                    flag = true;
                    vis.add(temp.right);
                }
                if(map.containsKey(temp) && !vis.contains(map.get(temp))){
                    flag = true;
                    q.add(map.get(temp));
                    vis.add(map.get(temp));
                }

            }
            if(flag)count++;

        }
        return count;

    }
    public void findParents(TreeNode A,Map<TreeNode,TreeNode> map,int B){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.val == B){
                    leafNode = temp;
                }
                if(temp.left != null){
                    q.add(temp.left);
                    map.put(temp.left,temp);
                }
                if(temp.right != null){
                    q.add(temp.right);
                    map.put(temp.right,temp);
                }
            }
        }
    }



    public static void main(String[] args) {
        BurnTree burnTree = new BurnTree();
        TreeNode root = burnTree.addNode(new int[]{7, 7, 4, 1, -1, -1, -1, -1 });
        System.out.println(burnTree.solve(root, 1));
    }
}
