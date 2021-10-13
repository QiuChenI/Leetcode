package leetcode.test;

/**
 * 非平衡二叉搜索树
 * 左节点小   右节点大
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {
    //树根节点
    private TreeNode<T> root;


    public BinarySearchTree() {

    }

    public void insert(T arg) {
        if (root == null) {
            root = new TreeNode<>(arg);
        }

    }


    static final class TreeNode<T> {
        T var;
        TreeNode left;
        TreeNode right;
        public TreeNode() {

        }
        public TreeNode(T var) {
            this.var = var;
        }
    }
}
