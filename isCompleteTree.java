/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        //使用队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root != null)
            queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;//证明此节点已经无左右孩子
            }
        }
        
        //校验
        while(!queue.isEmpty()){
            TreeNode tmp = queue.peek();
            if(tmp != null){
                return false;
            }else{
                queue.poll();
            }
        }
        
        return true;
    }
}