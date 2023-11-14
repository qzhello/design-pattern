package com.qzh.overview.structure;

/**
 * 桥接模式
 * 桥接模式是一种结构型设计模式，它将抽象部分与实现部分分离，允许它们可以独立地变化。桥接模式通过组合多个对象来完成更复杂的功能，而不是继承单个类。
 * <p>
 * 适配器模式是用来解决接口不兼容的问题，桥接模式是用来解决抽象与实现分离的问题。
 */
public class BridgePattern {

    public static void main(String[] args) {
        Color redColor = new RedColor();
        Color blueColor = new BlueColor();
        Shape redCircle = new Circle(redColor);
        Shape blueCircle = new Circle(blueColor);
        redCircle.applyColor(); // 输出：圆形 应用红色
        blueCircle.applyColor(); // 输出：圆形 应用蓝色
    }

    interface Color {
        void applyColor();
    }

    static class RedColor implements Color {
        @Override
        public void applyColor() {
            System.out.println("应用红色");
        }
    }

    static class BlueColor implements Color {
        @Override
        public void applyColor() {
            System.out.println("应用蓝色");
        }
    }

    abstract static class Shape {
        protected Color color;

        public Shape(Color color) {
            this.color = color;
        }

        public abstract void applyColor();
    }

    static class Circle extends Shape {
        public Circle(Color color) {
            super(color);
        }

        @Override
        public void applyColor() {
            System.out.print("圆形 ");
            color.applyColor();
        }
    }

    static class Square extends Shape {
        public Square(Color color) {
            super(color);
        }

        @Override
        public void applyColor() {
            System.out.print("矩形 ");
            color.applyColor();
        }
    }

}
