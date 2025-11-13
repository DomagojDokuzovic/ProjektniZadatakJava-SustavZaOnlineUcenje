package hr.tvz.entity;

import java.util.HashSet;

public final class Lesson implements Evaluatable, Named {

    private String name;
    private HashSet<Fact> facts;
    private Subject subject;
    private Teacher createdBy;


    Lesson(String name, HashSet<Fact> facts, Subject subject, Teacher teacher) {
        this.name = name;
        this.facts = facts;
        this.subject = subject;
        this.createdBy = teacher;
    }


    public static class LessonBuilder{
        private String builderName;
        private Subject builderSubject;
        private HashSet<Fact> builderFacts;
        private Teacher builderCreatedBy;

        public LessonBuilder(){
            builderName = "";
            builderSubject = null;
            builderFacts = new HashSet<>();
            builderCreatedBy = null;
        }

        public LessonBuilder setName(String name){
            this.builderName = name;
            return this;
        }
        public LessonBuilder setFacts(HashSet<Fact> facts){
            this.builderFacts = facts;
            return this;
        }
        public LessonBuilder setSubject(Subject subject){
            this.builderSubject = subject;
            return this;
        }
        public LessonBuilder setCreatedBy(Teacher teacher){
            this.builderCreatedBy = teacher;
            return this;
        }
        public Lesson build(){
            return new Lesson(builderName,builderFacts,builderSubject,builderCreatedBy);
        }
    }



    public void addFact(Fact newFact) {
        facts.add(newFact);
    }

    @Override
    public int evaluate() {
        return evaluate(facts);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void changeName(String newName) {
        this.name = newName;
    }



    public Teacher getCreatedBy() {return createdBy;}
    public Subject getSubject() {return subject;}
}
