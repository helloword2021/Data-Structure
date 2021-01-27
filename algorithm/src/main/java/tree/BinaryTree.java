package tree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author : xy
 * @Desc : 二叉树深度遍历
 * @Date: Created in 2021/1/26 15:44
 **/
public class BinaryTree {


    /**
     * 2. * 构建二叉树
     * 3. * @param inputList 输入序列
     * 4.
     */
    public static TreeNode createBinaryTree(LinkedList<Integer>
                                                    inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 20. * 二叉树前序遍历
     * 21. * @param node 二叉树节点
     * 22.
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 33. * 二叉树中序遍历
     * 34. * @param node 二叉树节点
     * 35.
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 47. * 二叉树后序遍历
     * 48. * @param node 二叉树节点
     * 49.
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }


    /**
     * 61. * 二叉树节点
     * 62.
     */
    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>
                (Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null,
                                null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println(" 前序遍历： ");
        preOrderTraveral(treeNode);
        System.out.println(" 中序遍历： ");
        inOrderTraveral(treeNode);
        System.out.println(" 后序遍历： ");
        postOrderTraveral(treeNode);
    }


}
