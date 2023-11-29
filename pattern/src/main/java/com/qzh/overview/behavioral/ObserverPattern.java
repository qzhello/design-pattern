package com.qzh.overview.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 是一种行为型设计模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听一个主题对象的状态变化。
 * 当主题对象的状态发生改变时，所有依赖于它的观察者对象都会收到通知并自动更新。
 */
public class ObserverPattern {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("新消息：这是一条观察者模式的示例");
    }

    interface Observer {
        void update(String message);
    }

    static class ConcreteObserver implements Observer {
        private String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " 收到消息：" + message);
        }
    }

    interface Subject {
        void addObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers(String message);
    }

    static class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }
    }
}
