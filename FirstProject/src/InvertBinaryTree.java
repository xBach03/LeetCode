public class InvertBinaryTree {
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
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode temp = left;
        left = right;
        right = temp;
        root.left = left;
        root.right = right;
        return root;
    }
    public static void print(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] Args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(2, n1, n2);
        TreeNode n6 = new TreeNode(7, n3, n4);
        TreeNode root = new TreeNode(4, n5, n6);
        print(invertTree(root));
    }
}
