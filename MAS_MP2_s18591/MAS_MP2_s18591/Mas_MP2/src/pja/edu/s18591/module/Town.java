package pja.edu.s18591.module;

import pja.edu.s18591.exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Town {
    private long id;
    private String name;
    private County county;
    private List<Building> buildings = new ArrayList<>();

    public Town(long id, String name) {
        this.id = id;
        setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        if(this.county == county){
            return;
        }
        if(this.county == null){
            this.county = county;
            county.addTown(this);
        }else if(county == null){
            County tmp = this.county;
            this.county = null;
            tmp.removeTown(this);
        }else {
            County tmp = this.county;
            this.county = null;
            tmp.removeTown(this);

            this.county = county;
            county.addTown(this);
        }
    }
    ///////////////////////////////////////////////////////////

    public List<Building> getBuildings() {
        return Collections.unmodifiableList(buildings);
    }

    public void addBuilding(Building building){
     if(building == null){
         throw new ValidationException("building could not be null");
     }
     if(this.buildings.contains(building)){
         return;
     }
     this.buildings.add(building);
     building.setTown(this);
    }
    public void removeBuilding(Building building){
        if(building == null){
            throw new ValidationException("building could not be null");
        }
        if(!this.buildings.contains(building)){
            return;
        }
        this.buildings.remove(building);
        building.setTown(null);
    }
}
