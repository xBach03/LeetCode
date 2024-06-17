import com.sun.source.tree.Tree;

public class SubtreeOfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null) {
            return false;
        }
        if(root.val != subRoot.val) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
    }
    public static void main(String[] Args) {
        TreeNode r0 = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2, r0, null);
        TreeNode r4 = new TreeNode(4, r1, r2);
        TreeNode r5 = new TreeNode(5);
        TreeNode r3 = new TreeNode(3, r4, r5);
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s4 = new TreeNode(4, s1, s2);
        System.out.println(isSubtree(r3, s4));
    }

}
