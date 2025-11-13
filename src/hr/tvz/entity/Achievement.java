package hr.tvz.entity;

public final record Achievement(String name, String requirement) implements Named{
    @Override
    public String getName() {return name;}

}
