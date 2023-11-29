package com.qzh.pattern.behavioral;

/**
 * 责任链模式/职责链模式
 * 是一种行为型设计模式，它将请求的发送者和接收者解耦，允许多个对象都有机会处理请求。责任链模式将这些对象连接成一条链，并沿着这条链传递请求，直到有一个对象能够处理请求为止。
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger(0);
        Logger fileLogger = new FileLogger(1);
        Logger emailLogger = new EmailLogger(2);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(emailLogger);

        consoleLogger.logMessage(0, "这是一条普通信息"); // 输出：控制台日志：这是一条普通信息
        consoleLogger.logMessage(1, "这是一条调试信息"); // 输出：控制台日志：这是一条调试信息，文件日志：这是一条调试信息
        consoleLogger.logMessage(2, "这是一条错误信息"); // 输出：控制台日志：这是一条错误信息，文件日志：这是一条错误信息，电子邮件日志：这是一条错误信息
    }

    static abstract class Logger {
        protected int level;
        protected Logger nextLogger;

        public void setNextLogger(Logger nextLogger) {
            this.nextLogger = nextLogger;
        }

        public void logMessage(int level, String message) {
            if (this.level <= level) {
                write(message);
            }
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }

        protected abstract void write(String message);
    }

    static class ConsoleLogger extends Logger {
        public ConsoleLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("控制台日志：" + message);
        }
    }

    static class FileLogger extends Logger {
        public FileLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("文件日志：" + message);
        }
    }

    static class EmailLogger extends Logger {
        public EmailLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("电子邮件日志：" + message);
        }
    }
}
