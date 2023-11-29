package com.qzh.overview.structure;

/**
 * 代理模式
 * 是一种结构型设计模式，它允许通过一个代理对象来控制对另一个对象的访问。代理模式在不改变原始对象的情况下，
 * 提供了对原始对象的间接访问，以此来控制对原始对象的访问权限、增加额外的功能或延迟加载。
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // 图像并未加载，直到调用display()方法
        image1.display();
        image2.display();

        // 第二次调用，图像不再加载，直接显示
        image1.display();
        image2.display();

        /*
         * 从磁盘加载图像：image1.jpg
         * 显示加载中...
         * 显示图像：image1.jpg
         * 从磁盘加载图像：image2.jpg
         * 显示加载中...
         * 显示图像：image2.jpg
         * 显示加载中...
         * 显示图像：image1.jpg
         * 显示加载中...
         * 显示图像：image2.jpg
         */
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("从磁盘加载图像：" + filename);
        }

        @Override
        public void display() {
            System.out.println("显示图像：" + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            System.out.println("显示加载中...");
            realImage.display();
        }
    }
}
