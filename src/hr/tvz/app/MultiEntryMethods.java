package hr.tvz.app;

import hr.tvz.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static hr.tvz.app.EntryUtil.*;

public class MultiEntryMethods {


    public static void subjectSetEntry(Scanner scanner, Set<Subject> mySubjects) {
        do {

            //Entering a name for the Subject
            String validTextEntry = null;
            do {
                System.out.print("Enter name of Subject no#" + (mySubjects.size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, mySubjects, scanner.nextLine().trim());
            } while (validTextEntry == null);

            //Adding the newly created Subject to the Set of Subjects
            mySubjects.add(new Subject(validTextEntry));
            System.out.println("Subject '" + validTextEntry + "' successfully added.\n");

        } while (askToContinue(scanner, "Enter another Subject?"));

        System.out.println("\n=== ENTERED SUBJECTS ===");
        mySubjects.forEach(s -> System.out.println("- " + s.name()));
    }


    public static void achievementSetEntry(Scanner scanner, Set<Achievement> myAchievements) {
        do {

            //Entering a name for the Achievement
            String validTextEntry = null;
            do {
                System.out.print("Enter name of Achievement no#" + (myAchievements.size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, myAchievements, scanner.nextLine().trim());
            } while (validTextEntry == null);

            //Entering a requirement for the Achievement
            System.out.print("Enter requirement for achieving'" + validTextEntry + "': ");
            String requirement = scanner.nextLine().trim();

            //Adding the newly created Achievement to the Set of Achievements
            myAchievements.add(new Achievement(validTextEntry, requirement));
            System.out.println("Achievement '" + validTextEntry + "' successfully added.\n");

        } while (askToContinue(scanner, "Would you like to add another Achievement?"));

        System.out.println("\n=== ENTERED ACHIEVEMENTS ===");
        myAchievements.forEach(a -> System.out.println("- " + a.name() + " → " + a.requirement()));
    }

    public static void factSetEntry(Scanner scanner, Set<Fact> myFacts) {
        do {

            //Entering a text for the Fact
            String validTextEntry = null;
            do {
                System.out.print("Enter text for Fact no#" + (myFacts.size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, myFacts, scanner.nextLine().trim());
            } while (validTextEntry == null);

            //Entering a points value for the Fact
            int validNumberEntry = -1;
            do{
                System.out.print("Enter points value for this fact: ");
                validNumberEntry = EntryUtil.validPointsEntry(scanner, scanner.nextLine().trim());
            } while (validNumberEntry == -1);

            //Adding the newly created Fact to the Set of Facts
            myFacts.add(new Fact(validTextEntry, validNumberEntry));
            System.out.println("Fact: '" + validTextEntry + "', worth: " + validNumberEntry + " pts, successfully added.\n");

        } while (askToContinue(scanner, "Would you like to add another Fact?"));

        System.out.println("\n=== ENTERED Facts ===");
        myFacts.forEach(a -> System.out.println("- " + a.text() + " (" + a.points() +" pts)" ));
    }




    public static void lessonSetEntry(Scanner scanner, Teacher creatorTeacher, Set<Subject> mySubjects ){
        do {
            //Creating a Lesson builder
            Lesson.LessonBuilder lb = new Lesson.LessonBuilder();

            //Choosing a Subject for the Lesson and sending it to the Builder
            lb.setSubject(EntryUtil.chooseSubject(scanner, mySubjects));

            //Choosing a name for the Lesson and sending it to the Builder
            String validTextEntry = null;
            do {
                System.out.print("Enter name for Lesson no#" + (creatorTeacher.getOwnedLessons().size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, creatorTeacher.getOwnedLessons(), scanner.nextLine().trim());
            } while (validTextEntry == null);
            lb.setName(validTextEntry);

            //Creating a set of Facts for the Lesson, filling it, and sending it to the Builder
            HashSet<Fact> myFacts = new HashSet<>();
            MultiEntryMethods.factSetEntry(scanner,myFacts);
            lb.setFacts(myFacts);

            //Sending the creating Teacher to the Builder
            lb.setCreatedBy(creatorTeacher);

            //Building the Lesson and adding it to the Teacher's owned Lessons
            creatorTeacher.createLesson(lb.build());


        }while (askToContinue(scanner, "Would you like to add another Lesson?"));

    }

    public static void teacherSetEntry(Scanner scanner, Set<Teacher> myTeachers, Set<Subject> mySubjects){
        do {

            //Entering a name for the Teacher
            String validTextEntry = null;
            do {
                System.out.print("Enter name of Teacher no#" + (myTeachers.size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, myTeachers, scanner.nextLine().trim());
            } while (validTextEntry == null);

            //Creating a new Teacher with the entered name
            Teacher currentTeacher = new Teacher(validTextEntry);

            //Going into LessonsEntry so the Teacher can have his lessons created
            MultiEntryMethods.lessonSetEntry(scanner,currentTeacher,mySubjects);

            //Adding the newly created Teacher to the Set of Teachers
            myTeachers.add(currentTeacher);
            System.out.println("Teacher '" + validTextEntry + "' successfully added.\n");

        } while (askToContinue(scanner, "Enter another Teacher?"));

        System.out.println("\n=== ENTERED Teachers ===");
        myTeachers.forEach(s -> System.out.println("- " + s.getName()));

    }

    public static void studentSetEntry(Scanner scanner, Set<Student> myStudents, ArrayList<Lesson> allAvailableLessons, Set<Achievement> allAvailableAchievements){
        do {
            //Entering a name for the Student
            String validTextEntry = null;
            do {
                System.out.print("Enter name of Student no#" + (myStudents.size() + 1) + ": ");
                validTextEntry = EntryUtil.validEntryIntoNamedSet(scanner, myStudents, scanner.nextLine().trim());
            } while (validTextEntry == null);

            //Creating a new Student with the entered name
            Student currentStudent = new Student(validTextEntry);


            //Choosing lessons that the Student will take
            currentStudent.setOwnedLessons(EntryUtil.chooseLessons(scanner,allAvailableLessons));

            //Choosing Achievements that the Student will get
            currentStudent.setAchievements(EntryUtil.chooseAchievements(scanner,allAvailableAchievements));

            //Adding the newly created Student to the Set of Students
            myStudents.add(currentStudent);
            System.out.println("Student '" + validTextEntry + "' successfully added.\n");

        } while (askToContinue(scanner, "Enter another Student?"));

        System.out.println("\n=== ENTERED Students ===");
        myStudents.forEach(student -> System.out.println("- " + student.getName()));

    }

}
