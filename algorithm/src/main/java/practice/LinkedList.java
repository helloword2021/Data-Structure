package practice;

/**
 * @Author : helloworld
 * @Desc : 判断链表是否有环
 * 解题思路 : 两个运动员跑步 一个速度 1m/s ,一个2m/s,环形跑道, 2m/s的运动员一定能追上1m/s的运动员
 * @Date: Created in 2021/1/27 10:32
 **/
public class LinkedList {

    //是否是环形
    public static boolean isCirCle(Node head){
        Node p1 = head;
        Node p2 = head ;

        while(p2 != null && p2.next != null){
            p1 = p1.next ;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }
        return  false;

    }

    //节点
    private static class Node {
        int data ;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
     //   node4.next = node1;
        System.out.println(isCirCle(node1));


    }
}
