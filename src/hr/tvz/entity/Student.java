package hr.tvz.entity;

import java.util.HashSet;

public final class Student extends User {
    private HashSet<Lesson> learnedLessons;
    private HashSet<Achievement> achievements;

    public Student(String username) {super(username);}


    public void learnLesson(Lesson newLesson) {
        learnedLessons.add(newLesson);
    }


    public void addAchievement(Achievement newAchievement) {
        achievements.add(newAchievement);
    }



}
