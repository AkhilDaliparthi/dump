package Linked;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, Node> cache;
    Node head, tail;
    int capacity;
    class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;
        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        Node () {

        }
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
        this.cache = new HashMap();
        this.capacity = capacity;
    }


    public void put(Integer key, Integer value) {
        Node node = cache.getOrDefault(key, null);
        if (node!=null) {
            removeNode(node);
        } else {
            if (cache.size() == capacity) {
                node = tail.prev;
                removeNode(node);
                cache.remove(node.key);
            }
        }
        node = new Node(key, value);
        addNode(node);
        cache.put(key, node);
    }

    public int get(Integer key) {
        Node node = cache.getOrDefault(key, null);
        if (node!=null) {
            removeNode(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    void addNode (Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }



    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(2,2);
        lruCache.put(1,1);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(4));
    }
}
