package com.qzh.overview.creation;

import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式：创建重复的对象，又能保持性能
 * 优点：
 * 原型模式是在内存中进行二进制流的拷贝，要比直接new一个对象性能好，特别是在一个循环体内创建大量对象时。
 * 原型模式可以简化对象创建的过程，可以直接拷贝现有的原型实例的值，实现对象复用。
 * 场景：
 * 1. 资源优化
 * 2. 性能和安全要求
 * 3. 一个对象有多个修改者
 * 4. 深拷贝、浅拷贝
 */
public class ProtoTypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        Proto proto = new Proto();
        Proto protoChild = new Proto();
        proto.setName("Proto");
        proto.setAge(11);
        protoChild.setName("child");
        protoChild.setAge(11111);
        protoChild.setChild(null);
        proto.setChild(protoChild);
        Proto cloneObj1 = proto.clone();
        Proto cloneObj2 = proto.clone();

        System.out.println("child:" + protoChild + "," + protoChild.getName());

        System.out.println(cloneObj1 + "," + cloneObj1.getChild().getName());
        System.out.println(cloneObj2 + "," + cloneObj2.getChild().getName());

        Proto protoDeep = new Proto();
        protoDeep.setName("ProtoDeep");
        protoDeep.setAge(22);
        protoDeep.setChild(protoChild);
        Proto cloneDeepObj1 = protoDeep.deepClone();
        protoChild.setName("deepChild");
        // 深copy
        Proto cloneDeepObj2 = SerializationUtils.clone(protoDeep);
        System.out.println(cloneDeepObj1 + "," + cloneDeepObj1.getChild().getName());
        System.out.println(cloneDeepObj2 + "," + cloneDeepObj2.getChild().getName());
    }

    @Data
    public static class Proto implements Cloneable, Serializable {
        private String name;
        private int age;
        private Proto child;

        @Override
        protected Proto clone() throws CloneNotSupportedException {
            return (Proto) super.clone();
        }

        // 不能做到子属性copy，只能做到浅copy，因为子属性是引用类型，只是copy了引用
        public Proto deepClone() {
            try {
                // 输出 (序列化)
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(this);
                // 输入 (反序列化)
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                return (Proto) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public String toString() {
            return this.hashCode() + ", Proto{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", child=" + child +
                    '}';
        }
    }
}
