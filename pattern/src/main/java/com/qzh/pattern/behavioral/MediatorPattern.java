package com.qzh.pattern.behavioral;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 * 是一种行为型设计模式，它通过一个中介者对象来封装一系列对象之间的交互。
 * 中介者模式可以降低对象之间的耦合性，从而使其更易于维护和扩展。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);
        User user3 = new User("Charlie", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.sendMessage("大家好！");
    }

    @Data
    static class User {
        private String name;
        private ChatRoom chatRoom;

        public User(String name, ChatRoom chatRoom) {
            this.name = name;
            this.chatRoom = chatRoom;
        }

        public void sendMessage(String message) {
            chatRoom.sendMessage(this, message);
        }

        public void receiveMessage(String message) {
            System.out.println(name + " 收到消息：" + message);
        }
    }

    static class ChatRoom {
        private List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public void sendMessage(User sender, String message) {
            for (User user : users) {
                if (user != sender) {
                    user.receiveMessage(sender.getName() + ": " + message);
                }
            }
        }
    }
}
