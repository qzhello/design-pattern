package com.qzh.overview.behavioral;

/**
 * 命令模式
 * 是一种行为型设计模式，它将请求或操作封装成对象，从而使得请求的发送者和接收者解耦。命令模式允许请求在不同的时间执行、排队或记录，并且支持撤销操作。
 */
public class CommandPattern {

    public static void main(String[] args) {
        Light light = new Light();
        Command turnOnCommand = new TurnOnLightCommand(light);
        Command turnOffCommand = new TurnOffLightCommand(light);

        // 执行命令
        turnOnCommand.execute();
        turnOffCommand.execute();
    }

    interface Command {
        void execute();
    }

    static class Light {
        public void turnOn() {
            System.out.println("灯已打开");
        }

        public void turnOff() {
            System.out.println("灯已关闭");
        }
    }

    static class TurnOnLightCommand implements Command {
        private Light light;

        public TurnOnLightCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    static class TurnOffLightCommand implements Command {
        private Light light;

        public TurnOffLightCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }
}
