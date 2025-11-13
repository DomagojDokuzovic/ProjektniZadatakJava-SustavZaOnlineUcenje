package hr.tvz.entity;

public class InvalidLessonCreationException extends RuntimeException {
    public InvalidLessonCreationException(String message) {
        super(message);
    }
}
