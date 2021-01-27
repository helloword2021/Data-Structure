package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : xy
 * @Desc : 二叉树层序遍历 广度遍历
 * @Date: Created in 2021/1/26 16:25
 **/
public class WideItearTree {

    /**
     2. * 二叉树层序遍历
     3. * @param root 二叉树根节点
     4. */ public static void levelOrderTraversal(BinaryTree.TreeNode root){
        Queue<BinaryTree.TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
        queue.offer(root);
         while(!queue.isEmpty()){
            BinaryTree.TreeNode node = queue.poll();
             System.out.println(node.data);
             if(node.leftChild != null){
                 queue.offer(node.leftChild);
                 }
             if(node.rightChild != null){
               queue.offer(node.rightChild);
               }
            }
        }


}


