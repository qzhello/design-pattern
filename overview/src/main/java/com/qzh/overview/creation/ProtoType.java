package com.qzh.overview.creation;

import lombok.Data;

/**
 * 原型模式：创建重复的对象，又能保持性能
 * 场景：
 * 1. 资源优化
 * 2. 性能和安全要求
 * 3. 一个对象有多个修改者
 * 4. 深拷贝、浅拷贝
 */
public class ProtoType {

    public static void main(String[] args) throws CloneNotSupportedException {
        Proto proto = new Proto();
        proto.setName("Proto");
        proto.setAge(11);
        Proto cloneObj = proto.clone();
        System.out.println(cloneObj.getAge());
        System.out.println(cloneObj.getName());
    }

    @Data
    public static class Proto implements Cloneable {
        private String name;
        private int age;

        @Override
        protected Proto clone() throws CloneNotSupportedException {
            Proto proto = new Proto();
            proto.setAge(this.age);
            proto.setName(this.name);
            return proto;
        }
    }
}
