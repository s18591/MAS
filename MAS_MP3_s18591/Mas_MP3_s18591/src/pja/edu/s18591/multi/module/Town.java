package pja.edu.s18591.multi.module;

public class Town extends Settlement {
    private int crafts;

    public Town(String name, int crafts) {
        super(name);
        setCrafts(crafts);
    }

    public int getCrafts() {
        return crafts;
    }

    public void setCrafts(int crafts) {
        this.crafts = crafts;
    }
}
