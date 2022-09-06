package Linked;

import java.util.HashMap;

public class LFUCache {

    class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    int leastFreq;
    HashMap<Integer, Node> cacheMap;
    HashMap<Integer, LRUCache> freqCacheMap;

    LFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        freqCacheMap = new HashMap<>();
        leastFreq = 0;
    }

    class LRUCache {
        Node head, tail;
        int length;
        LRUCache() {
            this.length = 0;
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            length++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            length--;
        }

        public Node removeLastNode() {
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    public void put(int key, int val) {
        Node found = cacheMap.get(key);
        if(found != null) {
            LRUCache lruCache = freqCacheMap.get(found.freq);
            lruCache.remove(found);
            if(lruCache.length==0) {
                leastFreq++;
            }
            found.val = val;
            found.freq++;
        } else {
            if(cacheMap.size()==capacity) {
                LRUCache cache = freqCacheMap.get(leastFreq);
                cacheMap.remove(cache.removeLastNode().key);
            }
            found = new Node(key, val);
            leastFreq = 1;
        }
        LRUCache cache = freqCacheMap.getOrDefault(found.freq, new LRUCache());
        cache.add(found);
        cacheMap.put(key, found);
        freqCacheMap.put(found.freq, cache);
    }

    public int get(int key) {
        Node found = cacheMap.get(key);
        if(found != null) {
            LRUCache lruCache = freqCacheMap.get(found.freq);
            lruCache.remove(found);
            if(lruCache.length==0) {
                leastFreq++;
            }
            found.freq++;
            LRUCache cache = freqCacheMap.getOrDefault(found.freq, new LRUCache());
            cache.add(found);
            cacheMap.put(key, found);
            freqCacheMap.put(found.freq, cache);
            return found.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
