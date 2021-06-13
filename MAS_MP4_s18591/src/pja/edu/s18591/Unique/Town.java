package pja.edu.s18591.Unique;

import pja.edu.s18591.Attribute.exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Town {
    private long id;
    private String name;

    private static List<Town> extent = new ArrayList<>();

    public Town(long id, String name) {
        setId(id);
        setName(name);
        extent.add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
            for(Town t : extent){
                if(t.getId() == id){
                    throw new ValidationException("id should be unique");
                }
            }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("name could not be empty");
        }
        this.name = name;
    }

    public static List<Town> getExtent() {
        return Collections.unmodifiableList(extent);
    }
}
