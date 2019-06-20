package collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

public class CustomHashMap<K, E> {
    private int capacity = 16;
    private float loadFactor = .75F;
    private CustomNode[] table = new CustomNode[capacity];

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);
        map.put(10, 10);

        map.displayAll();

    }

    private void displayAll() {
        new HashMap(10,(float) 1.0);


        for(int i = 0; i < capacity; i++) {
            System.out.println(this.table[i]);
        }
    }

    private void put(K key, E val) {
        CustomNode newNode = new CustomNode(key.hashCode(), key, val, null);
        int index = key.hashCode() & (this.capacity - 1);
        if (this.table[index] == null) {
            this.table[index] = newNode;
        } else {
            CustomNode node = this.table[index];
            while(node.getNext()!=null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    @Data
    @AllArgsConstructor
    static class CustomNode<K, E> {
        private int hashCode;
        private K key;
        private E val;
        private CustomNode next;
    }
}

