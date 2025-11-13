package hr.tvz.entity;

import java.util.Collection;

public interface Named{
    String getName();
    default void changeName(String newName){}

    public default Named findByName(Collection<Named> collection, String name){
        for (Named item : collection) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }
}
