package ru.geekbrains.java.oop.at.members;

public class Robot implements Participants {
    private String name;
    private int maxLength;
    private int maxHeight;
    private boolean success = true;

    public Robot(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void run() {
        System.out.println(name + " может пробежать " + maxLength + " м.");
    }

    public void jump() {
        System.out.println(name + " может перепрыгнуть " + maxHeight + " м.");

    }
}
