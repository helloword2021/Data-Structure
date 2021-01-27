package array;

/**
 * @Author : helloworld
 * @Description :手写链表
 * @Result:
 * @Date: Created in 2020/01/14 下午 5:26
 **/
public class MyLinkedList {

    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * @param data  插入元素
     * @param index 插入位置
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node insertedNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertedNode;
            last = insertedNode;

            //插入头部
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
            //尾部插入
        } else if (index == size) {
            last.next = insertedNode;
            last = insertedNode;
        } else {
            //插入中间 两个指向
            Node preNode = get(index - 1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 删除节点
     *
     * @param index 索引
     * @return
     */
    public Node remove(int index) {
        // to do
        return null;
    }

    /**
     * @param index 根据index查找 Node
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void outPut() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    //自定义节点
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3, 0);
        myLinkedList.insert(4, 1);
        myLinkedList.insert(5, 2);
        myLinkedList.insert(6, 1);
        myLinkedList.outPut();
    }

}
