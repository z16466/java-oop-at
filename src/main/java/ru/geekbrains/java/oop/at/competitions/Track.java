package ru.geekbrains.java.oop.at.competitions;

import ru.geekbrains.java.oop.at.members.Participants;

public class Track implements Subjects{
    private String name;
    private int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void check(Participants member) {
        member.run();
        member.setSuccess(member.getMaxLength() >= length);
        if (member.getSuccess()) {
            System.out.println("Участник " + member.getName() + " пробежал " + length + " м.");
        } else {
            System.out.println("Участник " + member.getName() + " не пробежал " + length + " м и выбыл из соревнований.");
        }
    }
}
