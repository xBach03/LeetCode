public class MaximumDepth {
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
    public static void print(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
    public static void main(String[] Args) {
        TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(20, n1, n2);
        TreeNode n5 = new TreeNode(3, n3, n4);
        System.out.println(maxDepth(n5));
    }
}
