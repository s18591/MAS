package pja.edu.s18591.multi.module;

import pja.edu.s18591.multi.Interface.ICastle;
import pja.edu.s18591.multi.exception.ValidationException;

public class WalledCity extends Town implements ICastle {
    private String residence;
    private int fortification;
    public WalledCity(String name, int crafts, String residence,int fortification) {
        super(name, crafts);
        setResidence(residence);
        setFortification(fortification);
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        if(residence == null || residence.isBlank()){
            throw new ValidationException("residence could be empty");
        }
    }

    @Override
    public int getFortification() {
        return fortification;
    }

    @Override
    public void setFortification(int fortification) {
        this.fortification = fortification;
    }
}
