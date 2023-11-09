package com.qzh.overview.creation;

public class AbstractFactory {

    public static void main(String[] args) {
        HuaWeiMatePhoneFactory huaWeiMatePhoneFactory = new HuaWeiMatePhoneFactory();
        HuaWeiWenJieCarFactory huaWeiWenJieCarFactory = new HuaWeiWenJieCarFactory();

        System.out.println(huaWeiMatePhoneFactory.createPhone().call());
        System.out.println(huaWeiWenJieCarFactory.createCar().run());
    }

    public static class HuaWeiMatePhoneFactory extends HuaWeiPhoneFactory {
        @Override
        public AbstractPhone createPhone() {
            return new Mate60();
        }
    }

    public static class HuaWeiWenJieCarFactory extends HuaWeiCarFactory {
        @Override
        public AbstractCar createCar() {
            return new WenJie();
        }

    }

    public static abstract class HuaWeiPhoneFactory extends HuaWeiFactory {
        @Override
        public AbstractCar createCar() {
            return null;
        }

        @Override
        public abstract AbstractPhone createPhone();
    }

    public static abstract class HuaWeiCarFactory extends HuaWeiFactory {
        @Override
        public abstract AbstractCar createCar();

        @Override
        public AbstractPhone createPhone() {
            return null;
        }
    }

    public abstract static class HuaWeiFactory {
        public abstract AbstractCar createCar();

        public abstract AbstractPhone createPhone();
    }

    public static class WenJie extends AbstractCar {

        @Override
        public String run() {
            return "run";
        }
    }

    public static class Mate60 extends AbstractPhone {

        @Override
        public String call() {
            return "call";
        }
    }

    public static abstract class AbstractCar {
        public abstract String run();
    }

    public static abstract class AbstractPhone {
        public abstract String call();
    }
}
