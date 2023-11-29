package com.qzh.overview.behavioral;

import java.util.Iterator;

/**
 * 迭代器模式
 * 是一种行为型设计模式，它提供一种顺序访问集合对象元素的方法，而无需暴露集合的内部表示。通过迭代器模式，我们可以遍历集合中的元素，而无需了解集合的底层结构。
 */
public class IteratorPattern {

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add("元素1");
        myList.add("元素2");
        myList.add("元素3");

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static class MyList implements Iterable<String> {
        private String[] elements;
        private int size;
        private int capacity;

        public MyList() {
            capacity = 10;
            elements = new String[capacity];
            size = 0;
        }

        public void add(String element) {
            if (size == capacity) {
                resize();
            }
            elements[size++] = element;
        }

        private void resize() {
            capacity *= 2;
            String[] newElements = new String[capacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }

        @Override
        public Iterator<String> iterator() {
            return new MyListIterator();
        }

        private class MyListIterator implements Iterator<String> {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public String next() {
                return elements[index++];
            }
        }
    }
}
