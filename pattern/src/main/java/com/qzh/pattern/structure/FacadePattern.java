package com.qzh.pattern.structure;

/**
 * 外观模式
 * 一种结构型设计模式，它提供了一个简化的接口，用于访问复杂系统中的一组接口。外观模式将复杂系统的功能封装起来，让客户端可以更方便地使用系统功能而不需要了解其内部复杂结构。
 */
public class FacadePattern {

    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();
        computerFacade.shutdown();
    }

    static class CPU {
        public void start() {
            System.out.println("CPU 启动");
        }

        public void shutdown() {
            System.out.println("CPU 关闭");
        }
    }

    static class Memory {
        public void start() {
            System.out.println("内存启动");
        }

        public void shutdown() {
            System.out.println("内存关闭");
        }
    }

    static class HardDrive {
        public void start() {
            System.out.println("硬盘启动");
        }

        public void shutdown() {
            System.out.println("硬盘关闭");
        }
    }

    static class ComputerFacade {
        private CPU cpu;
        private Memory memory;
        private HardDrive hardDrive;

        public ComputerFacade() {
            cpu = new CPU();
            memory = new Memory();
            hardDrive = new HardDrive();
        }

        public void start() {
            System.out.println("计算机启动开始");
            cpu.start();
            memory.start();
            hardDrive.start();
            System.out.println("计算机启动完成");
        }

        public void shutdown() {
            System.out.println("计算机关闭开始");
            cpu.shutdown();
            memory.shutdown();
            hardDrive.shutdown();
            System.out.println("计算机关闭完成");
        }
    }
}
