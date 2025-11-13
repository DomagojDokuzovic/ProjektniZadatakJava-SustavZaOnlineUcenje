package hr.tvz.entity;

import java.util.HashSet;
import java.util.Set;

public abstract sealed class User implements Named, Evaluatable permits Student, Teacher{
    protected String username;
    protected Set<Lesson> ownedLessons;



    public User(String username) {
        this.username = username;
        this.ownedLessons = new HashSet<>();
    }

    public User(String username, HashSet<Lesson> ownedLessons) {
        this.username = username;
        this.ownedLessons = ownedLessons;
    }

    public Set<Lesson> getOwnedLessons() {return ownedLessons;}
    public void setOwnedLessons(Set<Lesson> ownedLessons) {this.ownedLessons = ownedLessons;}

    @Override
    public String getName() {return username;}
    @Override
    public void changeName(String newName) {this.username = newName;}
    @Override
    public int evaluate() {return evaluate(ownedLessons);}
}
