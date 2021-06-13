package pja.edu.s18591.Bug.module;

import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Bug.module.Contract;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Owner {
    String name;
    private Set<Contract> contracts = new HashSet<>();

    public Owner(String name) {
        this.name = name;
    }

    public Set<Contract> getContracts() {
        return Collections.unmodifiableSet(contracts);
    }

    public void addContract(Contract contract) {
        if(contract == null){
            throw new ValidationException("contract could not be null");
        }
        if(contract.getOwner() != this){
            throw new ValidationException("contract is not related with this owner");
        }
        this.contracts.add(contract);

    }
    public void removeContract(Contract contract) {
        if(contract == null){
            throw new ValidationException("contract could not be null");
        }
        this.contracts.remove(contract) ;
        contract.remove();
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

}
