package com.qzh.overview.structure;

/**
 * 装饰器模式
 * 装饰器模式通过创建包装类来实现功能的增强，而不是修改原始类。
 * 它允许在不改变现有对象结构的情况下，动态地向对象添加新的功能。装饰器模式通过创建一个装饰器类，
 * 该类实现了与原始对象相同的接口，并持有一个原始对象的引用。通过将原始对象传递给装饰器，我们可以在运行时动态地为原始对象添加新的行为。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("原味咖啡：" + simpleCoffee.getDescription() + "，价格：" + simpleCoffee.getCost() + "元");

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("加牛奶咖啡：" + milkCoffee.getDescription() + "，价格：" + milkCoffee.getCost() + "元");
    }

    interface Coffee {
        double getCost();

        String getDescription();
    }

    static class SimpleCoffee implements Coffee {
        @Override
        public double getCost() {
            return 5.0;
        }

        @Override
        public String getDescription() {
            return "普通咖啡";
        }
    }

    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost();
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription();
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double getCost() {
            return super.getCost() + 2.0;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + "，加牛奶";
        }
    }
}
