package pja.edu.s18591.multiAspect.module;

import pja.edu.s18591.multi.exception.ValidationException;

public abstract class Settlement {
    private String name;
    private Strategic strategic;

    public Settlement(String name,Strategic strategic) {
        setName(name);
        setStrategic(strategic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("Name could not be empty");
        }
    }

    public Strategic getStrategic() {
        return strategic;
    }

    private void setStrategic(Strategic strategic) {
        if(strategic == null){
            throw new ValidationException("Strategic could not be null");
        }
        this.strategic = strategic;
    }
}
