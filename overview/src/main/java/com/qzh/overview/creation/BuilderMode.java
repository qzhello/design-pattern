package com.qzh.overview.creation;

import lombok.Data;

/**
 * 例如：StringBuilder、Lombok的@Builder
 */
public class BuilderMode {

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