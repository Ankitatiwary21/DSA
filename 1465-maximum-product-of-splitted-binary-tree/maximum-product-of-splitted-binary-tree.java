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
    long maxProd = 0, totalSum = 0;
    final long MOD = 1_000_000_007;
    
    public int maxProduct(TreeNode root) {
        totalSum = dfs(root);
        dfs(root);
        return (int)(maxProd % MOD);
    }
    
    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long sum = node.val + dfs(node.left) + dfs(node.right);
        maxProd = Math.max(maxProd, sum * (totalSum - sum));
        return sum;
    }
}