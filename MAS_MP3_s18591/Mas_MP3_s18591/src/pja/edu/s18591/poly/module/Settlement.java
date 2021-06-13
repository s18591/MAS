package pja.edu.s18591.poly.module;

import pja.edu.s18591.multi.exception.ValidationException;

public abstract class Settlement {
    private String name;
    private int tax;

    public Settlement(String name,int tax) {
        setName(name);
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("Name could not be empty");
        }
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public abstract int calculateTaxes();

}
