/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   int max;
    public int maxSumBST(TreeNode root) {
        max = 0;
        findMaxSum(root);
        return max;
    }
         public int[] findMaxSum(TreeNode node){
        if(node==null){
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = findMaxSum(node.left);
        int[] right = findMaxSum(node.right);
        boolean isBST = left[0]==1 && right[0]==1 && node.val>left[1] && node.val<right[2];
        int sum = node.val + left[3] + right[3];
        if(isBST){
            max = Math.max(max, sum);
        }
        return new int[]{isBST?1:0, Math.max(node.val,right[1]), Math.min(node.val,left[2]), sum};
    }
}