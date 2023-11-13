package com.qzh.overview.structure;

/**
 * 适配器模式
 * 背景：在现实世界中，我们常常遇到需要将两个不兼容的东西连接在一起的情况。
 * 类似地，当我们使用一个现有的类库或组件，但它的接口与我们的代码不匹配时，就需要使用适配器模式来进行适配。
 * <p>
 * 实现：类适配器和对象适配器。
 * 1. 类适配器： 通过多重继承，让适配器类同时继承目标接口和现有类，从而实现接口的适配。但在Java等语言中，由于不支持多重继承，类适配器的实现较为复杂，通常不常用。golang中可以直接继承。
 * 2. 对象适配器： 通过组合，让适配器类持有现有类的实例，并实现目标接口。对象适配器使用组合关系来实现接口的适配，较为常用。
 */
public class AdapterPattern {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        LegacyRectangleAdapter legacyRectangleAdapter = new LegacyRectangleAdapter(legacyRectangle);
        System.out.println(legacyRectangleAdapter.getArea());
    }

    /**
     * 适配器模式例子：比如想用getArea这种通用接口来计算矩形面积，
     * 但是现有的LegacyRectangle类没有实现这个接口，这时候就需要一个适配器来实现这个接口
     */
    static class LegacyRectangle {
        public double calculateArea() {
            // 计算矩形面积的复杂逻辑
            return 0.0;
        }
    }

    interface Rectangle {
        double getArea();
    }

    /**
     * calculateArea的调用就转化为了getArea的调用
     */
    static class LegacyRectangleAdapter implements Rectangle {
        private LegacyRectangle legacyRectangle;

        public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
            this.legacyRectangle = legacyRectangle;
        }

        @Override
        public double getArea() {
            return legacyRectangle.calculateArea();
        }
    }
}
