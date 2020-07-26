package ru.geekbrains.java.oop.at.competitions;

import ru.geekbrains.java.oop.at.members.Participants;

public class Wall implements Subjects{
    private String name;
    private int length;

    public Wall(String name, int length) {
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
        member.jump();
        member.setSuccess(member.getMaxHeight() >= length);
        if (member.getSuccess()) {
            System.out.println("Участник " + member.getName() + " перепрыгнул стену высотой " + length + " м.");
        } else {
            System.out.println("Участник " + member.getName() + " не перепрыгнул стену высотой " + length + " м и выбыл из соревнований.");
        }
    }
}
