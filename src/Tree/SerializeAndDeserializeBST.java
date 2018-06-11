package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class SerializeAndDeserializeBST {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode (2);
        n1.right = n2;
        System.out.print(deserialize(serialize(n1)));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curNode = st.pop();
            sb.append(curNode.val);
            sb.append(" ");
            if (curNode.right != null) {
                st.push(curNode.right);
            }
            if (curNode.left != null) {
                st.push(curNode.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] nums = data.trim().split("\\s+");
        Arrays.stream(nums).forEach(System.out::println);
        List<Integer> numList = Arrays.stream(nums).map(Integer::valueOf).collect(Collectors.toList());
        return buildTree(numList);
    }

    private static TreeNode buildTree(List<Integer> numList) {
        if (numList.size() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(numList.get(0));

        if (numList.size() == 1) {
            return root;
        }

        List<Integer> leftSubTree = new LinkedList<>();
        List<Integer> rightSubTree = new LinkedList<>();

        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) < numList.get(0)) {
                leftSubTree.add(numList.get(i));
            } else {
                rightSubTree.add(numList.get(i));
            }
        }
        root.left = buildTree(leftSubTree);
        root.right = buildTree(rightSubTree);

        return root;
    }
}
