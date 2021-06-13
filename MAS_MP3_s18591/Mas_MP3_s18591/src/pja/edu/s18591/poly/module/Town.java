package pja.edu.s18591.poly.module;

import pja.edu.s18591.poly.module.Settlement;

public class Town extends Settlement {
    private int crafts;

    public Town(String name,int tax, int crafts) {
        super(name,tax);
        setCrafts(crafts);
    }

    public int getCrafts() {
        return crafts;
    }

    public void setCrafts(int crafts) {
        this.crafts = crafts;
    }

    @Override
    public int calculateTaxes() {
        return getTax() + crafts;
    }
}
