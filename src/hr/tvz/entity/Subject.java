package hr.tvz.entity;

import java.util.Collection;

public record Subject(String name) implements Named {


    @Override
    public String getName() {return name;}

}
