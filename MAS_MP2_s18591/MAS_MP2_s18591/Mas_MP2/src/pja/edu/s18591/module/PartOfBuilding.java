package pja.edu.s18591.module;

import pja.edu.s18591.exception.ValidationException;

public class PartOfBuilding {
    private String nameOfPart;
    private Building building;

    public PartOfBuilding(String nameOfPart,Building building) {
        this.nameOfPart = nameOfPart;
        setBuilding(building);
    }

    public String getNameOfPart() {
        return nameOfPart;
    }

    public void setNameOfPart(String nameOfPart) {
        if(nameOfPart == null || nameOfPart.isBlank()){
            throw new ValidationException("name could not be null");
        }
        this.nameOfPart = nameOfPart;
    }

    public Building getBuilding() {
        return building;
    }

    private void setBuilding(Building building) {
        if(building == null){
            throw new ValidationException("owner could not be null");
        }
        this.building = building;
        building.addPart(this);
    }

    public void delete(){
        building.removePart(this);
        building = null;
    }

}
