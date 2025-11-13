package hr.tvz.app;

import hr.tvz.entity.Lesson;
import hr.tvz.entity.Named;
import hr.tvz.entity.Subject;
import hr.tvz.entity.Teacher;

import java.util.*;

public class EntryUtil {


    public static boolean askToContinue(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                return true;  // continue adding
            } else if (answer.equals("n")) {
                return false; // stop
            } else {
                System.out.println("Please enter 'y' for yes or 'n' for no.");
            }
        }
    }


    public static <T extends Named> String validEntryIntoNamedSet(Scanner scanner, Set<T> set, String entry){
        if (entry.isEmpty()) {
            System.out.println("Entry cannot be empty. Please try again.\n");
            return null;
        }
        if (set.stream().anyMatch(s -> s.getName().equalsIgnoreCase(entry))) {
            System.out.println("That entry already exists. Please try again.\n");
            return null;
        }
        return entry;
    }

    public static Integer validPointsEntry(Scanner scanner, String entry){
        if (entry.isEmpty()) {
            System.out.println("Entry cannot be empty. Please try again.\n");
            return -1;
        }
        try {
            int result = Integer.parseInt(entry);
            if(result < 0){
                System.out.println("Entry cannot be negative. Please try again.\n");
                return -1;
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Entry has to be integer. Please try again.\n");
            return -1;
        }
    }

    public static Subject chooseSubject(Scanner scanner, Set<Subject> subjects) {
        if (subjects.isEmpty()) {
            System.out.println("️No subjects available!");
            return null;
        }

        // Display all available subjects with numbers
        System.out.println("\nAvailable subjects:");
        int index = 1;
        List<Subject> subjectList = new ArrayList<>(subjects);
        for (Subject s : subjectList) {
            System.out.println(index++ + ". " + s.name());
        }

        Subject chosen = null;
        while (chosen == null) {
            System.out.print("Enter the number of the subject for this lesson: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= subjectList.size()) {
                    chosen = subjectList.get(choice - 1);
                } else {
                    System.out.println("Invalid number. Please choose between 1 and " + subjectList.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        System.out.println("Selected subject: " + chosen.name() + "\n");
        return chosen;
    }

    public static ArrayList<Lesson> gatherAllLessons (Set<Teacher> teachers){
        ArrayList<Lesson> lessons = new ArrayList<>();
        teachers.forEach(teacher -> lessons.addAll(teacher.getOwnedLessons()));
        return lessons;
    }

    public static Set<Lesson> chooseLessons (Scanner scanner, ArrayList<Lesson> availableLessons){
        if (availableLessons.isEmpty()) {
            System.out.println("️No lessons available!");
            return null;
        }

        // Display all available lessons with numbers
        System.out.println("\nAvailable lessons:");
        int index = 1;
        for (Lesson l : availableLessons) {
            System.out.println(index++ + ". " + l.getName());
        }

        System.out.println("\nEnter numbers of lessons you want to add separated by commas (e.g. 1,3,5):");

        String input = scanner.nextLine().trim();

        // Prepare result set
        Set<Lesson> chosenLessons = new HashSet<>();

        if (input.isEmpty()) {
            System.out.println("No input provided. Returning empty selection.\n");
            return chosenLessons;
        }

        // Split input
        String[] parts = input.split(",");

        for (String part : parts) {
            part = part.trim();

            // Check if part is a valid integer
            if (!part.matches("\\d+")) {
                // not an integer → ignore silently
                continue;
            }

            int choice = Integer.parseInt(part);

            // Check valid range
            if (choice < 1 || choice > availableLessons.size()) {
                // out-of-range → ignore silently
                continue;
            }

            // Add lesson to set
            chosenLessons.add(availableLessons.get(choice - 1));
        }

        return chosenLessons;
    }



    }



