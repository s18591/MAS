package pja.edu.s18591.poly.module;
import pja.edu.s18591.poly.module.Settlement;

public class Castle extends Settlement{
    private int fortification;

    public Castle(String name,int tax, int fortification) {
        super(name,tax);
        setFortification(fortification);
    }

    public int getFortification() {
        return fortification;
    }

    public void setFortification(int fortification) {
        this.fortification = fortification;
    }

    @Override
    public int calculateTaxes() {
        return  getTax() + fortification;
    }
}
