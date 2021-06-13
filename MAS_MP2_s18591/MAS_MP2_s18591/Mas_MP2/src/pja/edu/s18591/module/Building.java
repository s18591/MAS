package pja.edu.s18591.module;

import pja.edu.s18591.exception.ValidationException;

import java.util.*;

public class Building {
    private String name;
    private Town town;
    private List<PartOfBuilding> parts = new ArrayList<>();

    //////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////////
    public List<PartOfBuilding> getParts() {
        return Collections.unmodifiableList(parts) ;
    }

    public void addPart(PartOfBuilding part){
        if(part == null){
            throw new ValidationException("part could not be null");
        }
        if(part.getBuilding() != this){
            throw new ValidationException("not part of this building");
        }
        if(parts.contains(part)){
            return;
        }
        this.parts.add(part);
    }
    public  void removePart(PartOfBuilding part){
        if(part == null){
            throw new ValidationException("part could not be null");
        }
        if(part.getBuilding() != this){
            throw new ValidationException("not part of this building");
        }
        if(!parts.contains(part)){
            return;
        }
        this.parts.remove(part);
        part.delete();
    }
    public void delete(){
        List<PartOfBuilding> tmp = parts;
        for(int i = 0; i<tmp.size(); i++) {
            parts.get(i).delete();
        }
        this.setTown(null);
    }
}
