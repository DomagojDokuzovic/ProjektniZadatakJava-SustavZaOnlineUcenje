package hr.tvz.entity;

import java.util.HashSet;

public abstract sealed class User implements Named, Evaluatable permits Student, Teacher{
    protected String username;
    protected HashSet<Lesson> ownedLessons;



    public User(String username) {
        this.username = username;
        this.ownedLessons = new HashSet<>();
    }

    public User(String username, HashSet<Lesson> ownedLessons) {
        this.username = username;
        this.ownedLessons = ownedLessons;
    }

    public HashSet<Lesson> getOwnedLessons() {return ownedLessons;}

    @Override
    public String getName() {return username;}
    @Override
    public void changeName(String newName) {this.username = newName;}
    @Override
    public int evaluate() {return evaluate(ownedLessons);}
}
