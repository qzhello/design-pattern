package com.qzh.pattern.behavioral;

/**
 * 访问者模式
 * 是一种行为型设计模式，它允许在不改变被访问元素的类的前提下，定义作用于这些元素的新操作。
 * 访问者模式将数据结构与操作分离，使得操作可以独立地变化，而不影响数据结构。
 */
public class VisitorPattern {
    public static void main(String[] args) {
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();

        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor); // 输出：执行元素A的操作
        elementB.accept(visitor); // 输出：执行元素B的操作
    }

    // 访问者接口
    interface Visitor {
        void visitElementA(ElementA elementA);

        void visitElementB(ElementB elementB);
    }

    // 元素接口
    interface Element {
        void accept(Visitor visitor);
    }

    // 具体元素类 ElementA
    static class ElementA implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visitElementA(this);
        }

        // 元素A特有的操作
        void operationA() {
            System.out.println("执行元素A的操作");
        }
    }

    // 具体元素类 ElementB
    static class ElementB implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visitElementB(this);
        }

        // 元素B特有的操作
        void operationB() {
            System.out.println("执行元素B的操作");
        }
    }

    // 具体访问者类 ConcreteVisitor
    static class ConcreteVisitor implements Visitor {
        @Override
        public void visitElementA(ElementA elementA) {
            // 实现操作1，处理元素A
            elementA.operationA();
        }

        @Override
        public void visitElementB(ElementB elementB) {
            // 实现操作2，处理元素B
            elementB.operationB();
        }
    }
}
