package com.qzh.overview.behavioral;

/**
 * 备忘录模式
 */
public class MementoPattern {

    public static void main(String[] args) {
        Originator originator = new Originator();

        originator.setState("State1");
        Memento memento = originator.createMemento();

        originator.setState("State2");

        System.out.println("当前状态：" + originator.getState());

        originator.restoreMemento(memento);
        System.out.println("恢复后状态：" + originator.getState());
    }

    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    static class Originator {
        private String state;

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public Memento createMemento() {
            return new Memento(state);
        }

        public void restoreMemento(Memento memento) {
            this.state = memento.getState();
        }
    }
}
