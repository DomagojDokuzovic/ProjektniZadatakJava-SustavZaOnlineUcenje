package hr.tvz.entity;

import java.util.HashSet;
import java.util.Set;

public final class Student extends User {
    private Set<Achievement> achievements;

    public Student(String username) {super(username);}


    public void learnLesson(Lesson newLesson) {
        this.getOwnedLessons().add(newLesson);
    }


    public void addAchievement(Achievement newAchievement) {
        achievements.add(newAchievement);
    }

    public void setAchievements(Set<Achievement> achievements) {this.achievements = achievements;}



}
