package com.qzh.overview.behavioral;

/**
 * 状态模式
 * 是一种行为型设计模式，它允许一个对象在内部状态改变时改变其行为。状态模式将对象的行为封装在不同的状态类中，从而使得状态转换更加简洁和灵活。
 */
public class StatePattern {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.openDoor(); // 输出：电梯门打开
        elevator.move(); // 输出：电梯不能移动，先关闭门

        elevator.closeDoor(); // 输出：电梯门已关闭
        elevator.move(); // 输出：电梯开始移动

        elevator.openDoor();
    }

    interface ElevatorState {
        void openDoor();
        void closeDoor();
        void move();
    }

    static class DoorClosedState implements ElevatorState {
        @Override
        public void openDoor() {
            System.out.println("电梯门打开");
        }

        @Override
        public void closeDoor() {
            System.out.println("电梯门已关闭");
        }

        @Override
        public void move() {
            System.out.println("电梯开始移动");
        }
    }

    static class DoorOpenedState implements ElevatorState {
        @Override
        public void openDoor() {
            System.out.println("电梯门已打开");
        }

        @Override
        public void closeDoor() {
            System.out.println("电梯门关闭");
        }

        @Override
        public void move() {
            System.out.println("电梯不能移动，先关闭门");
        }
    }

    static class MovingState implements ElevatorState {
        @Override
        public void openDoor() {
            System.out.println("电梯不能打开门，先停止移动");
        }

        @Override
        public void closeDoor() {
            System.out.println("电梯门关闭");
        }

        @Override
        public void move() {
            System.out.println("电梯正在移动");
        }
    }

    static class Elevator {
        private ElevatorState currentState;

        public Elevator() {
            currentState = new DoorClosedState();
        }

        public void setState(ElevatorState state) {
            currentState = state;
        }

        public void openDoor() {
            currentState.openDoor();
        }

        public void closeDoor() {
            currentState.closeDoor();
        }

        public void move() {
            currentState.move();
        }
    }
}
