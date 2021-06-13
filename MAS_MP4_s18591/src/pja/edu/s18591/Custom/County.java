package pja.edu.s18591.Custom;
import pja.edu.s18591.Attribute.exception.ValidationException;

import java.util.*;

public class County {
   private String title;
   private Map<Long,Town> towns = new HashMap<>();

    public County(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        if(title == null || title.isBlank()){
            throw new ValidationException("title could not be empty");
        }
        this.title = title;
    }
    ///////////////////////////////////////////////////////////////////////////////////
    public Map<Long, Town> getTowns() {
        return Collections.unmodifiableMap(towns);
    }

    public List<Town> getTownList(){
        return new ArrayList<>(towns.values());
    }

    public Town findTownById(long townId){
        return towns.get(townId);
    }

    public void addTown(Town town){
        if(town == null){
            throw new ValidationException("town could not be null");
        }
        if(towns.containsKey(town.getId())){
            return;
        }
        towns.put(town.getId(),town);
        town.setCounty(this);
    }

    public void removeTown(Town town){
        if(town == null){
            throw new ValidationException("town could not be null");
        }
        ///////////////////////////////////////////////////////
        if(!town.getBuildings().isEmpty()){
            throw new ValidationException("Town could not be removed");
        }
        ////////////////////////////////////////////////////////
        if(towns.containsKey(town.getId())){
            return;
        }
        towns.remove(town.getId(),town);
        town.setCounty(null);
    }

}
