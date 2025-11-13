package hr.tvz.entity;

public class DuplicateLessonException extends RuntimeException {
    public DuplicateLessonException(String message) {
        super(message);
    }
}
