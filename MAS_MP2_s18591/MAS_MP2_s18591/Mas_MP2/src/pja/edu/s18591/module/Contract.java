package pja.edu.s18591.module;

import pja.edu.s18591.exception.ValidationException;
import java.time.LocalDate;

public class Contract {
    private LocalDate startDate;
    private float tax;
    private Owner owner;
    private County county;

    public Contract(LocalDate startDate, float tax, Owner owner, County county) {
        this.startDate = startDate;
        this.tax = tax;
        setCounty(county);
        setOwner(owner);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if(startDate == null){
            throw new ValidationException("start date could not be null");
        }
        this.startDate = startDate;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax){
        if(tax < 0){
            throw new ValidationException("tax could not be less then zero");
        }
        this.tax = tax;
    }

    public Owner getOwner() {
        return owner;
    }

    private void setOwner(Owner owner) {
        if(owner == null){
            throw new ValidationException("county could not be empty");
        }
        this.owner = owner;
        owner.addContract(this);
    }

    public County getCounty() {
        return county;
    }

    private void setCounty(County county) {
        if(county == null){
            throw new ValidationException("owner could not be empty");
        }
        if(county.getContract() != null){
           county.getContract().remove();
        }
        this.county = county;
        county.setContract(this);
    }

    public void remove(){
        if(this.county != null){
            County tmp = this.county;
            this.county = null;
            tmp.setContract(null);
        }
        if(this.owner != null){
            Owner tmp = this.owner;
            this.owner = null;
            tmp.removeContract(this);
        }
    }
}
