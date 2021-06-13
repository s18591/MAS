package pja.edu.s18591.Subset;

import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.XOR.County;

public class Owner {
    private String name;
    private Council council;
    public Owner(String name) {
        this.name = name;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("name could not be empty");
        }
        this.name = name;
    }

    public Council getCouncil() {
        return council;
    }

    public void setCouncil(Council council) {
        if (this.council == council) {
            return;
        }
        if (this.council == null) {
            this.council = council;
            council.addOwner(this);
        } else if (council == null) {
            Council tmp = this.council;
            this.council = null;
            tmp.removeOwner(this);
        } else {
            Council tmp = this.council;
            this.council = null;
            tmp.removeOwner(this);

            this.council = council;
            council.addOwner(this);
        }
        this.council = council;
    }
}
