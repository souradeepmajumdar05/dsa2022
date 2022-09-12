package dynamicPrograming.houseRobber;

public class HouseRobberIII {

    //public static void main(String [] args){
   //     System.out.println (rob(new int[]{1,2,3,1}));
   // }


    public int rob(TreeNode root)
    {
        int[] result = robUtility(root);
        return Math.max(result[0],result[1]);
    }
    public int[] robUtility(TreeNode root)
    {
        if(root == null)
        {
            int[] result = {0,0};
            return result;
        }

        int[] result = new int[2];
        int[] left=robUtility(root.left);
        int[] right=robUtility(root.right);
        result[0]=root.val+left[1]+right[1];                            //0 when root is choosen
        result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);//1 when root is not choosen

        return result;
    }
/**
 * Definition for a binary tree node.*/
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }


}
