package pja.edu.s18591.Subset;

import pja.edu.s18591.Attribute.exception.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Council {
    private String name;
    private Set<Owner> owners = new HashSet<>();
    private Owner chancellor;

    public Council(String name,Owner chancellor) {
        setName(name);
        setChancellor(chancellor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("name could not be null or empty");
        }
        this.name = name;
    }

    public Set<Owner> getOwners() {
        return Collections.unmodifiableSet(owners);
    }

    public void addOwner(Owner owner){
        if(owner == null){
            throw new ValidationException("owner could not be null");
        }
        if(this.owners.contains(owner)){
            return;
        }
        this.owners.add(owner);
        owner.setCouncil(this);
    }
    public void removeOwner(Owner owner){
        if(owner == null){
            throw new ValidationException("person could not be null");
        }
        if(this.chancellor == owner){
            throw new ValidationException("Chancellor could not be removed");
        }
        if(!this.owners.contains(owner)){
            return;
        }
        this.owners.remove(owner);
        owner.setCouncil(null);
    }

    public Owner getChancellor() {
        return chancellor;
    }

    public void setChancellor(Owner chancellor) {
        if(chancellor == null){
            throw new ValidationException("chancellor could not be null");
        }
        this.chancellor = chancellor;
        this.addOwner(chancellor);
    }
}
