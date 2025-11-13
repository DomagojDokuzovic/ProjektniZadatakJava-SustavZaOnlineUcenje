package hr.tvz.app;

import hr.tvz.entity.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ComparisonMethods {

    public static Evaluatable findMostValuable(Collection<Evaluatable> collection){
        Evaluatable currentBest = null;
        int bestValue = 0;

        for (Evaluatable item : collection) {
            int value = item.evaluate();
            if (currentBest == null || value > bestValue) {
                currentBest = item;
                bestValue = value;
            }
        }
        return currentBest;
    }


    public static Subject findBestSubject(Student student){
        if(student.getOwnedLessons() == null){
            System.out.println("Student " + student.getName() + " has no completed lessons.");
            return null;
        }

        HashSet<Lesson> lessons = student.getOwnedLessons();
        HashMap<Subject, Integer> subjectsWithValue = new HashMap<>();

        for(Lesson l : lessons){
            int lVal = l.evaluate();
            Subject s = l.getSubject();
            if(subjectsWithValue.containsKey(s)){
                subjectsWithValue.put(s, subjectsWithValue.get(s) + lVal);
            }else{
                subjectsWithValue.put(s, lVal);
            }
        }

        return subjectsWithValue.entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .get()
                                .getKey();
        }
}
