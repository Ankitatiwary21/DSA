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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)
        return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root); //1
        boolean b=false;
        while(!q.isEmpty())
        {
            int len=q.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                TreeNode cur=q.poll();
                res.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            if(b)
            {
                Collections.reverse(res);
            }
            l.add(res);
            b=!b;
        }
    return l;
    }
}