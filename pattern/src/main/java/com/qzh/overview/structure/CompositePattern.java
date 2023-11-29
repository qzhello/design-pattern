package com.qzh.overview.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * <p>
 * 在现实世界中，我们常常遇到整体和部分的层次结构。比如，公司由多个部门组成，每个部门可能又包含多个员工。在软件开发中，也经常遇到类似的层次结构，比如树形结构、目录结构等。
 * <p>
 * 组合模式通过将对象组合成树状结构来表示整体-部分的层次结构。它将叶子节点（单个对象）和组合节点（包含子节点的对象）统一看待，从而使得客户端可以统一地处理单个对象和组合对象，而不必关心它们之间的差异。
 * 组合模式的核心是定义一个组件接口，其中包含了组合对象和叶子对象的共同操作。然后，创建叶子节点类和组合节点类，它们都实现了组件接口。组合节点类中通常包含了一个子组件列表，用于存储它的子节点。
 */
public class CompositePattern {

    public static void main(String[] args) {
        Component root = new Composite("Root");

        Component node1 = new Composite("Node1");
        node1.add(new Leaf("Leaf1"));
        node1.add(new Leaf("Leaf2"));

        Component node2 = new Composite("Node2");
        node2.add(new Leaf("Leaf3"));

        root.add(node1);
        root.add(node2);

        root.display();
    }

    static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract void add(Component component);

        public abstract void remove(Component component);

        public abstract void display();
    }

    static class Leaf extends Component {
        public Leaf(String name) {
            super(name);
        }

        @Override
        public void add(Component component) {
            throw new UnsupportedOperationException("Leaf cannot add component.");
        }

        @Override
        public void remove(Component component) {
            throw new UnsupportedOperationException("Leaf cannot remove component.");
        }

        @Override
        public void display() {
            System.out.println(name);
        }
    }

    static class Composite extends Component {
        private List<Component> components = new ArrayList<>();

        public Composite(String name) {
            super(name);
        }

        @Override
        public void add(Component component) {
            components.add(component);
        }

        @Override
        public void remove(Component component) {
            components.remove(component);
        }

        @Override
        public void display() {
            System.out.println(name);
            for (Component component : components) {
                component.display();
            }
        }
    }
}
