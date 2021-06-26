package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XueweiHuang
 * @created 2021-06-26
 * @see <a href="https://leetcode-cn.com/problems/lru-cache/">LeetCode LRU Cache</a>
 */
public class HashAndDoublyLinkedListSolution {

    private final int capacity;

    class Entry {

        private int key;
        private int value;
        private Entry previous;
        private Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Entry> map;
    private final Entry lruEnd;
    private final Entry mruEnd;

    public HashAndDoublyLinkedListSolution(int capacity) {
        // initialize capacity
        this.capacity = capacity;
        // initialize hash map
        map = new HashMap<>((int) (capacity * 0.75 + 1), 0.75f);
        // initialize LRU_END and MRU_END
        lruEnd = new Entry(0, 0);
        mruEnd = new Entry(0, 0);
        // initialize doubly linked list
        lruEnd.next = mruEnd;
        mruEnd.previous = lruEnd;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            popToMRUEnd(entry);
            return entry.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            popToMRUEnd(entry);
        } else {
            Entry newEntry = new Entry(key, value);
            if (map.size() >= capacity) {
                Entry evictedEntry = evictLRUEnd();
                map.remove(evictedEntry.key);
            }
            putToMRUEnd(newEntry);
            map.put(key, newEntry);
        }
    }

    private void popToMRUEnd(Entry entry) {
        if (entry == mruEnd.previous) {
            // do nothing
        } else {
            removeEntry(entry);
            putToMRUEnd(entry);
        }
    }

    private void removeEntry(Entry entry) {
        entry.previous.next = entry.next;
        entry.next.previous = entry.previous;
    }

    private void putToMRUEnd(Entry entry) {
        entry.previous = mruEnd.previous;
        entry.next = mruEnd;
        mruEnd.previous.next = entry;
        mruEnd.previous = entry;
    }

    private Entry evictLRUEnd() {
        if (lruEnd.next == mruEnd) {
            return null;
        } else {
            Entry entry = lruEnd.next;
            removeEntry(lruEnd.next);
            return entry;
        }
    }

    public void printDLList() {
        Entry current = this.lruEnd.next;
        if (null == current) {
            System.out.println("Doubly linked list is empty!");
        } else {
            System.out.print("Entries: [LRU End - ");
            while (null != current && null != current.next) {
                System.out.print("Entry(key:" + current.key + ", value:" + current.value + ") ");
                current = current.next;
            }
            System.out.print("- MRU End]");
            System.out.println();
        }
    }
}