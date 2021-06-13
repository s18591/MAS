package pja.edu.s18591.multiAspect.module;

import pja.edu.s18591.multi.exception.ValidationException;

public class StrategicPoint extends Strategic {
    private String advantage;

    public StrategicPoint(String advantage) {
        setAdvantage(advantage);
    }

    public String getAdvantage() {
        return advantage;
    }

    private void setAdvantage(String advantage) {
        if(advantage == null || advantage.isBlank()){
            throw new ValidationException("advantage could not be null");
        }
        this.advantage = advantage;
    }
}
