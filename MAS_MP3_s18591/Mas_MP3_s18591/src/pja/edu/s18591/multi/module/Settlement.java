package pja.edu.s18591.multi.module;

import pja.edu.s18591.multi.exception.ValidationException;

public abstract class Settlement {
    private String name;

    public Settlement(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("Name could not be empty");
        }
    }


}
