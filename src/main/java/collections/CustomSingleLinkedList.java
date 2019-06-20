package collections;

import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomSingleLinkedList<E> {
    private int capacity = 10;
    private CustomNode first, last;
    private int size = 0;

    public static void main(String[] args) {

        CustomSingleLinkedList list = new CustomSingleLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("Display all elements of list.");
        list.displayAll();
        System.out.println("");

        System.out.println("Display elements of list at index 1.");
        System.out.println((list.get(1)).getVal());
        System.out.println("");

        System.out.println("remove elements of list at index 3 and display remaning all.");
        list.remove(3);
        list.displayAll();
    }

    private void remove(int i) {
        if (i == 0) {
            this.first = this.first.getNext();
        } else {
            CustomNode prvNode = findPrevioud(i);
            prvNode.setNext(prvNode.getNext().getNext());
        }
    }

    private CustomNode findPrevioud(int i) {
        CustomNode node = this.first;
        if (i == 0) return null;
        for (int j = 1; j < this.size; j++) {
            if (i == j) {
                break;
            }
            node = node.getNext();
        }
        return node;
    }

    private CustomNode get(int i) {
        CustomNode node = this.first;
        if (i == 0) {
            return node;
        } else if (i == this.size - 1) {
            return this.last;
        }
        int index = 1;
        while (node.getNext() != null) {
            if (i == index) {
                break;
            }
            node = node.getNext();
        }
        return node;
    }

    private void displayAll() {
        CustomNode node = this.first;
        System.out.println(node.getVal());
        while (node.getNext() != null) {
            node = node.getNext();
            System.out.println(node.getVal());
        }
    }

    private void add(E val) {
        CustomNode node = new CustomNode(val, null);
        CustomNode secondLastNode = this.last;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            secondLastNode.setNext(this.last);
        }
        this.size++;
    }

    @Data
    @AllArgsConstructor
    private class CustomNode<E> {
        public E val;
        @Nullable
        public CustomNode next;
    }
}