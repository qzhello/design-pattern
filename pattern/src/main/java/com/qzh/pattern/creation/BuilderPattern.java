package com.qzh.pattern.creation;

import lombok.Data;

/**
 * 功能：将复杂对象的构建过程与其表示分离
 * <p>
 * 背景：在某些情况下，一个对象的构建过程非常复杂，涉及多个步骤，每个步骤都可能有多种选择。如果直接在客户端代码中进行对象的构建，会导致构建过程变得庞大而复杂，难以维护和扩展。
 * <p>
 * 例如：StringBuilder、Lombok的@Builder
 */
public class BuilderPattern {

    public static void main(String[] args) {
        XiaoMiBuilder xiaoMiBuilder = new XiaoMiBuilder();
        Phone phone = xiaoMiBuilder.cpu("xiaolong 885")
                .name("xiaomi 11")
                .build();
        System.out.println(phone);
    }

    public static class XiaoMiBuilder extends AbstractBuilder {
        private Phone phone;

        public XiaoMiBuilder() {
            this.phone = new Phone();
        }

        @Override
        public AbstractBuilder name(String name) {
            phone.setName(name);
            return this;
        }

        @Override
        public AbstractBuilder cpu(String cpu) {
            phone.setCpu(cpu);
            return this;
        }

        @Override
        public Phone build() {
            return phone;
        }
    }

    public static abstract class AbstractBuilder {
        public abstract AbstractBuilder name(String name);

        public abstract AbstractBuilder cpu(String cpu);

        public abstract Phone build();
    }

    @Data
    public static class Phone {
        private String name;
        private String cpu;
    }

}