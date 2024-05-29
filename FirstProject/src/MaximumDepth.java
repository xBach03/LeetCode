public class MaximumDepth {
    public static class TreeNode {
        int val;
        InvertBinaryTree.TreeNode left;
        InvertBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, InvertBinaryTree.TreeNode left, InvertBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void print(InvertBinaryTree.TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public int maxDepth(TreeNode root) {

    }
}
