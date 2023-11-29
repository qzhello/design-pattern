package com.qzh.overview.creation;

/**
 * 单例模式
 * 场景：
 * 1. 多线程的线程池
 * 2. 数据库链接
 * 3. 系统环境变量
 * 4. 上下文
 */
public class SingletonPattern {
    /**
     * 双重检验锁+内存可见性
     */
    private static volatile SingletonPattern instance = null;

    /**
     * 构造器私有，保证外部无法实例化
     */
    private SingletonPattern() {
    }

    /**
     * 懒汉式
     */
    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    /**
     * 饿汉式
     */
    public static SingletonPattern getInstance2() {
        return instance;
    }

    /**
     * 双重检查锁
     */
    public static SingletonPattern getInstance3() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                    return instance;
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类
     */
    public static SingletonPattern getInstance4() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final SingletonPattern instance = new SingletonPattern();
    }
}
