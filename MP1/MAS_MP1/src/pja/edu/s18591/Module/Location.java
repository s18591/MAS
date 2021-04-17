package pja.edu.s18591.Module;

import pja.edu.s18591.Exeption.ValidationException;

import java.io.Serializable;

public class Location implements Serializable {
    private String empire;
    private String country;
    private String duchy;

    public Location(String empire, String country, String duchy) {
        setCountry(country);
        setDuchy(duchy);
        setEmpire(empire);
    }

    public String getEmpire() {
        return empire;
    }

    public void setEmpire(String empire) {
        if (empire == null || empire.isBlank()) {
            throw new ValidationException("empire could not be empty");
        }
        this.empire = empire;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new ValidationException("country could not be empty");
        }
        this.country = country;
    }

    public String getDuchy() {
        return duchy;
    }

    public void setDuchy(String duchy) {
        if (duchy == null || duchy.isBlank()) {
            throw new ValidationException("duchy could not be empty");
        }
        this.duchy = duchy;
    }

    @Override
    public String toString() {
        return "Empire: " + empire  +
                ", country: " + country  +
                ", duchy: " + duchy;
    }
}
