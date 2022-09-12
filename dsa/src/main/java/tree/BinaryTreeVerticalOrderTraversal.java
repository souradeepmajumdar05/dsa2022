package tree;

import javafx.util.Pair;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    /**
     * Definition of TreeNode:*/
      public static class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }
      static class StackNode{
          Integer pos;
          TreeNode node;
          StackNode(Integer pos,TreeNode node){
              this.node=node;
              this.pos=pos;
          }
      }


    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        Stack<StackNode> stack=new Stack<>();

        stack.add(new StackNode(0,root));
        while(!stack.empty()){
            int size=stack.size();
            for(int i=0;i<size;i++){
                StackNode posNode=stack.pop();
                if(map.get(posNode.pos)==null) {
                    List<Integer> tlist= new ArrayList<>();
                    tlist.add(posNode.node.val);
                    map.put(posNode.pos,tlist);
                }
                else
                    map.get(posNode.pos).add(posNode.node.val);

                if(posNode.node.left!=null){
                    stack.add(new StackNode(posNode.pos-1,posNode.node.left));
                }
                if(posNode.node.right!=null){
                    stack.add(new StackNode(posNode.pos+1,posNode.node.right));
                }
            }
        }
        for (int pos:map.keySet()){
            answer.add(map.get(pos));
        }
        return answer;
    }
    public static void main(String[] args){
        TreeNode root = new  TreeNode(3);
        root.left=new TreeNode(9);
        root.left.left=null;
        root.left.right=null;
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.left.left=null;
        root.right.left.right=null;
        root.right.right=new TreeNode(7);
        root.right.right.left=null;
        root.right.right.right=null;

        List<List<Integer>> answer=verticalOrder(root);
        for (int i=0;i<answer.size();i++){
            for(int j=0;j<answer.get(i).size();j++){
                System.out.print(answer.get(i).get(j)+"'");
            }
            System.out.println();
        }
    }
}
