package Tree;

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

        Note: If the given node has no in-order successor in the tree, return null.*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
    }
}

public class InorderSuccessor{
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode (2);
        n1.right = n2;
        System.out.print(inorderSuccessor(n1, n1).val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessorHelper(root, p);
    }

    private static TreeNode inorderSuccessorHelper(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessorHelper(root.right, p);
        } else {
            TreeNode left = inorderSuccessorHelper(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
