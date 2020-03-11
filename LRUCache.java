import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.
*/
public class LRUCache {
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.curSize = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            deleteNode(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (curSize >= capacity) {
            Node nodeToRemove = removeTail();
            cache.remove(nodeToRemove.key);
            curSize--;
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        addToFront(node);
        curSize++;
    }

    public void addToFront(Node node) {
        Node firstNode = head.next;
        node.next = firstNode;
        firstNode.prev = node;
        head.next = node;
    }

    public void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public Node removeTail() {
        Node node = tail.prev;
        Node prev = node.prev;
        prev.next = tail;
        tail.prev = prev;
        return node;
    }

    Map<Integer, Node> cache;
    int capacity;
    int curSize;
    Node head;
    Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));      // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));      // returns 4
    }
}