package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return output;
    }
    public void preOrder(TreeNode root){
        if(root==null)
            return;
        output.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
