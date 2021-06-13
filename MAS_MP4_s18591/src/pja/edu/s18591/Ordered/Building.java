package pja.edu.s18591.Ordered;

import pja.edu.s18591.Attribute.exception.ValidationException;

public class Building {
    private String name;
    private Town town;

    public Building(String name) {
        this.name = name;
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
//////////////////////////////////////////////////////////////////////////
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        if(this.town == town){
            return;
        }
        if(this.town == null){
            this.town = town;
            town.addBuilding(this);
        }else if(town == null){
            Town tmp = this.town;
            this.town = null;
            tmp.removeBuilding(this);
        }else {
            Town tmp = this.town;
            this.town = null;
            tmp.removeBuilding(this);

            this.town = town;
            town.addBuilding(this);
        }
    }

}
