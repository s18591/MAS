package pja.edu.s18591.XOR;

import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Ordered.Town;

import java.util.List;

public class Person {
    private String name;
    private Church church;
    private County county;

    public Person(String name) {
        setName(name);
    }

    public String getTitle() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("name could not be empty");
        }
        this.name = name;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        if(this.county != null){
            throw new ValidationException("this person already assigned to subjects of county");
        }
        if (this.church == church) {
            return;
        }
        if (this.church == null) {
            this.church = church;
            church.AddPerson(this);
        } else if (church == null) {
            Church tmp = this.church;
            this.church = null;
            tmp.removePerson(this);
        } else {
            Church tmp = this.church;
            this.church = null;
            tmp.removePerson(this);

            this.church = church;
            church.AddPerson(this);
        }
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        if(this.church != null){
            throw new ValidationException("this person already assigned us monk of church ");
        }
        if (this.county == county) {
            return;
        }
        if (this.county == null) {
            this.county = county;
            county.AddPerson(this);
        } else if (county == null) {
            County tmp = this.county;
            this.county = null;
            tmp.removePerson(this);
        } else {
            County tmp = this.county;
            this.county = null;
            tmp.removePerson(this);

            this.county = county;
            church.AddPerson(this);
        }
    }
}
