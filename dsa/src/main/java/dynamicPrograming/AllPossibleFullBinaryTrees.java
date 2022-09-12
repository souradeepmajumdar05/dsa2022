package dynamicPrograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
    Map<Integer,List<TreeNode>> dp = new HashMap<Integer,List<TreeNode>>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        if(n==1){
            List<TreeNode> temp= new ArrayList<TreeNode>();
            temp.add(new TreeNode());
            return temp;
        }
        if(dp.get(n)!=null){
            return dp.get(n);
        }
        List<TreeNode> res= new ArrayList<TreeNode>();
        for(int l=0 ;l < n;l++){
            int r=n-l-1;
            List<TreeNode> left =allPossibleFBT(l);
            List<TreeNode> right =allPossibleFBT(r);
            for(TreeNode t1:left){
                for(TreeNode t2:right){
                    res.add(new TreeNode(0,t1,t2));
                }
            }
        }
        dp.put(n,res);
        return res;
    }

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

}
