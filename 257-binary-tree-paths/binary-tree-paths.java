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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null)
        return res;
        backtrack(root,res,"");
        return res;
}
public void backtrack(TreeNode root,List<String>r,String s)
{
    if(root==null)
    return;
    s=s+Integer.toString(root.val);
    if(root.left==null && root.right==null)
    {
        r.add(s);
    }
    s=s+"->";
    backtrack(root.left,r,s);
    backtrack(root.right,r,s);
}
}