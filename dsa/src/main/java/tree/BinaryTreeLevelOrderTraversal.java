package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        BinaryTreePostOrderTraversal.TreeNode left;
        BinaryTreePostOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreePostOrderTraversal.TreeNode left, BinaryTreePostOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> levelOrder(BinaryTreePostOrderTraversal.TreeNode root) {
        if (root==null)
            return new ArrayList<>();;
        Queue<BinaryTreePostOrderTraversal.TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> row=new ArrayList<>();
            for(int i=0;i< size;i++){
                BinaryTreePostOrderTraversal.TreeNode tempRoot= queue.poll();
                row.add(tempRoot.val);
                if(tempRoot.left!=null)
                queue.add(tempRoot.left);
                if(tempRoot.right!=null)
                queue.add(tempRoot.right);
            }
            output.add(row);
        }
        return output;
    }
}
