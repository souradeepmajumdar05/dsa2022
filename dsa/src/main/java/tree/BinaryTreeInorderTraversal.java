package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    /**
     * Definition for a binary tree node.*/
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

    List<Integer> output=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return output;
    }
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        output.add(root.val);
        inOrder(root.right);
    }

}
