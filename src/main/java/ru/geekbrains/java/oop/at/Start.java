package ru.geekbrains.java.oop.at;

import ru.geekbrains.java.oop.at.competitions.Subjects;
import ru.geekbrains.java.oop.at.competitions.Track;
import ru.geekbrains.java.oop.at.competitions.Wall;
import ru.geekbrains.java.oop.at.members.Cat;
import ru.geekbrains.java.oop.at.members.Human;
import ru.geekbrains.java.oop.at.members.Participants;
import ru.geekbrains.java.oop.at.members.Robot;

public class Start {
    public static void main(String[] args) {
        Participants cat1 = new Cat("White cat", 100, 2);
        Participants cat2 = new Cat("Black cat", 150, 3);
        Participants cat3 = new Cat("Red cat", 50, 1);

        Participants human1 = new Human("White man", 130, 3);
        Participants human2 = new Human("Black man", 70, 2);
        Participants human3 = new Human("Red man", 110, 1);

        Participants robot1 = new Robot("Steel robot", 140, 4);
        Participants robot2 = new Robot("Liquid robot", 80, 3);
        Participants robot3 = new Robot("Wooden robot", 120, 6);

        Participants[] members = {cat1, cat2, cat3, human1, human2, human3, robot1, robot2, robot3};

        Subjects track1 = new Track("Бег",100);
        Subjects track2 = new Track("Бег",120);
        Subjects track3 = new Track("Бег",150);

        Subjects wall1 = new Wall("Прыжки",2);
        Subjects wall2 = new Wall("Прыжки",3);
        Subjects wall3 = new Wall("Прыжки",5);

        Subjects[] subjects = {track1, wall1, track2, wall2, track3, wall3};

        for (int i = 0; i < subjects.length; i++) {
            System.out.print("\n\nСоревнование " + (i + 1) + ". ");
            if (subjects[i].getName().equals("Бег")) {
                System.out.println("Пробежать " + subjects[i].getLength() + " м.");
            } else {
                System.out.println("Перепрыгнуть стену высотой " + subjects[i].getLength() + " м.");
            }

            for (Participants member : members) {
                if (member.getSuccess()) {
                    System.out.println();
                    subjects[i].check(member);
                }

            }
        }
    }
}
