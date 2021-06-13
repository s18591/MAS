package pja.edu.s18591.multiAspect.module;
import pja.edu.s18591.multiAspect.module.Settlement;

public class Castle extends Settlement{
    private int fortification;

    public Castle(String name,Strategic strategic,int fortification) {
        super(name,strategic);
        setFortification(fortification);
    }

    public int getFortification() {
        return fortification;
    }

    public void setFortification(int fortification) {
        this.fortification = fortification;
    }
}
