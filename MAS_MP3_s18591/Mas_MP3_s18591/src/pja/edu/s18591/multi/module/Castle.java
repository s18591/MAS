package pja.edu.s18591.multi.module;

import pja.edu.s18591.multi.Interface.ICastle;

public class Castle extends Settlement implements ICastle {
    private int fortification;

    public Castle(String name, int fortification) {
        super(name);
       setFortification(fortification);
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
