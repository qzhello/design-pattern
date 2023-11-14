package com.qzh.overview.behavioral;

/**
 * 模版方法
 * 是一种行为型设计模式，它定义一个算法的骨架，而将具体的实现步骤延迟到子类中。模板方法模式使得子类可以在不改变算法结构的情况下重新定义算法的某些步骤。
 * 在软件开发中，我们经常遇到一些算法或流程，其中包含一系列固定的步骤，但其中某些步骤的实现可能因情况而异。如果直接在父类中实现整个算法，会导致子类无法自由地改变算法的某些步骤。
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }

    static abstract class Game {
        abstract void initialize();

        abstract void startPlay();

        abstract void endPlay();

        // 模板方法
        public final void play() {
            initialize();
            startPlay();
            endPlay();
        }
    }

    static class Cricket extends Game {
        @Override
        void initialize() {
            System.out.println("板球游戏：初始化");
        }

        @Override
        void startPlay() {
            System.out.println("板球游戏：开始");
        }

        @Override
        void endPlay() {
            System.out.println("板球游戏：结束");
        }
    }

    static class Football extends Game {
        @Override
        void initialize() {
            System.out.println("足球游戏：初始化");
        }

        @Override
        void startPlay() {
            System.out.println("足球游戏：开始");
        }

        @Override
        void endPlay() {
            System.out.println("足球游戏：结束");
        }
    }
}
