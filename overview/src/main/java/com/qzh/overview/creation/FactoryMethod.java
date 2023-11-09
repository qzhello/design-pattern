package com.qzh.overview.creation;

public class FactoryMethod {

    public static void main(String[] args) {
        AbstractCarFactory benzFactory = new BenzFactory();
        System.out.println(benzFactory.createCar().run());

        AbstractCarFactory jeepFactory = new JeepFactory();
        System.out.println(jeepFactory.createCar().run());
    }

    public static class BenzFactory extends AbstractCarFactory {
        @Override
        public AbstractCar createCar() {
            return new Benz();
        }
    }

    public static class JeepFactory extends AbstractCarFactory {
        @Override
        public AbstractCar createCar() {
            return new Jeep();
        }
    }

    public static abstract class AbstractCarFactory {
        public AbstractCar createCar() {
            return null;
        }
    }

    public static abstract class AbstractCar {
        public String run() {
            return null;
        }
    }

    public static class Jeep extends AbstractCar {
        @Override
        public String run() {
            return "jeep";
        }
    }

    public static class Benz extends AbstractCar {
        @Override
        public String run() {
            return "benz";
        }
    }
}
