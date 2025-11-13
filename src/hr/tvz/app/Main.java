package hr.tvz.app;

import hr.tvz.entity.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.RandomAccessFile;

import static hr.tvz.app.EntryUtil.askToContinue;
import static hr.tvz.app.EntryUtil.gatherAllLessons;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Set<Subject> mySubjects = new HashSet<>();
        Set<Teacher> myTeachers = new HashSet<>();
        Set<Achievement> myAchievements = new HashSet<>();
        Set<Student> myStudents = new HashSet<>();




        MultiEntryMethods.subjectSetEntry(scanner, mySubjects);
        MultiEntryMethods.teacherSetEntry(scanner,myTeachers,mySubjects);

        MultiEntryMethods.achievementSetEntry(scanner, myAchievements);
        MultiEntryMethods.studentSetEntry(scanner,myStudents,gatherAllLessons(myTeachers),myAchievements);



          scanner.close();
    }
}
