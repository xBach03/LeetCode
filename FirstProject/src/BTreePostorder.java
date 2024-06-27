import java.util.ArrayList;
import java.util.List;

public class BTreePostorder {
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
    List<Integer> ans = new ArrayList<>();
    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }
}
