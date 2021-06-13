package pja.edu.s18591.Bug.module;
import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Bug.module.Contract;

public class County {
   private String title;
   private Contract contract;

    public County(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        if(title == null || title.isBlank()){
            throw new ValidationException("title could not be empty");
        }
        this.title = title;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        if(contract == null){
            if(this.contract != null) {
                this.contract.remove();
            }
            this.contract = null;
        }else {
            if (contract.getCounty() != this) {
                throw new ValidationException("contract is not related with this county");
            }
            this.contract = contract;
        }
    }

}
