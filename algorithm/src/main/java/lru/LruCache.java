package lru;

import java.util.HashMap;

/**
 * @Author : helloworld
 * @Desc : LRU least used  最少使用算法
 * 每次put值的时候 ,把最近使用的值 put到最上面,删除最少使用的值
 * 实现: 用双向列表
 * @Date: Created in 2021/1/27 14:57
 **/
public class LruCache {


    private Node head;
    private Node end;
    //缓存上限;
    private int limit;
    private HashMap<String, Node> hashMap;

    public LruCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //如果key不存在, 插入key -value
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            //如果key存在 则刷新key value
            node.value = value;
            refreshNode(node);
        }
    }

    //刷新被访问的节点位置 把node更新到最上边,最右边
    private void refreshNode(Node node) {
        if (node == null) {
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 删除节点
     *
     * @param node
     * @return
     */
    private String removeNode(Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == end) {
            //移除尾节点
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            //移除头节点
            head = head.next;
            head.pre = null;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    //尾部插入node
    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    class Node {
        public Node pre;
        public Node next;
        public String key;
        public String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(5);
        lruCache.put("001", " 用户1信息");
        lruCache.put("002", " 用户1信息");
        lruCache.put("003", " 用户1信息");
        lruCache.put("004", " 用户1信息");
        lruCache.put("005", " 用户1信息");
        lruCache.get("002");
        System.out.println(lruCache.toString());
//        lruCache.put("004", " 用户2信息更新");
//        lruCache.put("006", " 用户6信息");
        System.out.println(lruCache.get("001"));;
        System.out.println(lruCache.get("006"));;
    }
}
