package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
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
    public List<Integer> postOrderTraversal(TreeNode root) {
        postOrder(root);
        return output;
    }
    public void postOrder(TreeNode root){
        if(root==null)
            return;
        output.add(root.val);
        postOrder(root.left);
        postOrder(root.right);
    }

}
