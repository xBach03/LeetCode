public class SymmetricTree {
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
    public boolean check(TreeNode leftRoot, TreeNode rightRoot) {
        if(leftRoot == null && rightRoot == null) {
            return true;
        } else if(leftRoot == null || rightRoot == null) {
            return false;
        }
        return leftRoot.val == rightRoot.val && check(leftRoot.left, rightRoot.right) && check(leftRoot.right, rightRoot.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static void main(String[] Args) {

    }
}
