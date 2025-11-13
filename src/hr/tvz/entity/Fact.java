package hr.tvz.entity;

public record Fact(String text, int points) implements Evaluatable, Named {

    @Override
    public int evaluate(){
        return points;
    }

    @Override
    public String getName() {
        return text;
    }
}
