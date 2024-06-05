public class BalancedBinaryTree {
    public static class TreeNode {
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
    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(maxDepth(root) == -1) {
            return false;
        }
        return true;
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        if(maxLeft == -1 || maxRight == -1) {
            return -1;
        }
        if(Math.abs(maxLeft - maxRight) > 1) {
            return -1;
        }
        return Math.max(maxLeft, maxRight) + 1;
    }
    public static void main(String[] Args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n1, null);
        TreeNode n4 = new TreeNode(3, null, n2);
        TreeNode n5 = new TreeNode(2, n3, null);
        TreeNode n6 = new TreeNode(2, null, n4);
        TreeNode n7 = new TreeNode(1, n5, n6);
        System.out.println(isBalanced(n7));
    }
}
