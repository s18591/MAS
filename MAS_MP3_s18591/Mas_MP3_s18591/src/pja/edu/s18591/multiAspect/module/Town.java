package pja.edu.s18591.multiAspect.module;

import pja.edu.s18591.multiAspect.module.Settlement;

public class Town extends Settlement {
    private int crafts;

    public Town(String name,Strategic strategic,int crafts) {
        super(name,strategic);
        setCrafts(crafts);
    }

    public int getCrafts() {
        return crafts;
    }

    public void setCrafts(int crafts) {
        this.crafts = crafts;
    }
}
