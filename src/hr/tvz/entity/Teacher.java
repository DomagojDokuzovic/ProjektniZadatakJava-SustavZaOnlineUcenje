package hr.tvz.entity;

import java.util.HashSet;

public final class Teacher extends User{


    public Teacher(String username) {super(username);}

    public void createLesson(Lesson newLesson) {
        ownedLessons.add(newLesson);
    }


}
