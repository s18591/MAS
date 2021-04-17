package pja.edu.s18591.Module;

import pja.edu.s18591.Exeption.ValidationException;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class County implements Serializable {
    public static final String EXTENT_PATH = "src/pja/edu/s18591/Source/Data";
    private static List<County> counties = new ArrayList<>();

    private String title;
    private LocalDate dateOfCreation;
    private String owner;
    private Set<String> religions = new HashSet<>();
    private List<String> baronies = new ArrayList<>();
    private FormOfGovernment formOfGovernment;
    private Integer budget;
    private Integer income;
    private static Set<String> knownReligions = new HashSet<>();
    private Location location;
    static {
        knownReligions.add("Shamanism");
    }

    //only mandatory attributes with the ability to add multiple barons and religions
    public County(String title, LocalDate dateOfCreation, String owner, List<String> baronies, Set<String> religions, FormOfGovernment formOfGovernment,Location location) {
        setTitle(title);
        setDateOfCreation(dateOfCreation);
        setOwner(owner);
        addReligions(religions);
        addBaronies(baronies);
        setFormOfGovernment(formOfGovernment);
        setLocation(location);
        counties.add(this);
    }

    //only mandatory attributes without the ability to add multiple barons and religions
    public County(String title, LocalDate dateOfCreation, String owner, String barony, String religion, FormOfGovernment formOfGovernment,Location location) {
        setTitle(title);
        setDateOfCreation(dateOfCreation);
        setOwner(owner);
        addBarony(barony);
        addReligion(religion);
        setFormOfGovernment(formOfGovernment);
        setLocation(location);
        counties.add(this);
    }

    //all attributes without the ability to add multiple barons and religions
    public County(String title, LocalDate dateOfCreation, String owner, String barony, String religion, FormOfGovernment formOfGovernment,Location location, Integer budget, Integer income) {
        setTitle(title);
        setDateOfCreation(dateOfCreation);
        setOwner(owner);
        addBarony(barony);
        addReligion(religion);
        setFormOfGovernment(formOfGovernment);
        setBudget(budget);
        setIncome(income);
        setLocation(location);
        counties.add(this);
    }

    //all attributes with the ability to add multiple barons and religions
    public County(String title, LocalDate dateOfCreation, String owner, List<String> baronies, Set<String> religions, FormOfGovernment formOfGovernment,Location location, Integer budget, Integer income) {
        setTitle(title);
        setDateOfCreation(dateOfCreation);
        setOwner(owner);
        addBaronies(baronies);
        addReligions(religions);
        setFormOfGovernment(formOfGovernment);
        setBudget(budget);
        setIncome(income);
        setLocation(location);
        counties.add(this);
    }
///////////////////////////////////////////////////////////////

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if(location == null){
            throw new ValidationException("Location can not be empty");
        }
        this.location = location;
    }

    ///////////////////////////////////////////////////////////////
    public static List<County> findByOwner(String owner){
        List<County> result = new ArrayList<>();
        if(owner == null || owner.trim().isBlank()){
            return result;
        }
      result = counties.stream()
                .filter(x -> x.getOwner().equals(owner))
                .collect(Collectors.toList());
        return result;
    }
///////////////////////////////////////////////////////////////
    public static List<County> getCounties() {
        return Collections.unmodifiableList(counties);
    }

    public static void saveExtent() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXTENT_PATH));
            oos.writeObject(counties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadExtent() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXTENT_PATH));
            counties = (List<County>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////////////////////////

    public static Set<String> getKnownReligions() {
        return Collections.unmodifiableSet(knownReligions);
    }

    public static void addKnownReligion(String known) {
        if (known == null || known.isBlank()) {
            throw new ValidationException("known religion could not be empty");
        }
        knownReligions.add(known);
    }

    public static void addKnownReligions(Set<String> known) {
        if (known.contains(null) || known.stream().anyMatch(x -> x == null || x.isBlank())) {
            throw new ValidationException("known religion could not be empty");
        } else {
            knownReligions.addAll(known);
        }
    }

    public static void removeKnownReligion(String known) {
        if (knownReligions.size() < 2) {
            throw new ValidationException("can not remove last religion");
        }
        knownReligions.remove(known);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getProfit() {
        if (income != null && budget != null) {
            return income + budget;
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        if (income != null && income < 0) {
            throw new ValidationException("income could not be negative");
        }
        this.income = income;
    }
////////////////////////////////////////////////////////////////////////////////////

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        if (budget != null && budget < 0) {
            throw new ValidationException("budget could not be negative");
        }
        this.budget = budget;
    }

////////////////////////////////////////////////////////////////////////////////////

    public FormOfGovernment getFormOfGovernment() {
        return formOfGovernment;
    }

    public void setFormOfGovernment(FormOfGovernment formOfGovernment) {
        if (formOfGovernment == null) {
            throw new ValidationException("formOfGovernment could not be empty");
        }
        this.formOfGovernment = formOfGovernment;
    }

////////////////////////////////////////////////////////////////////////////////////


    public Set<String> getReligions() {
        return religions;
    }

    public void addReligion(String religion) {
        if (religion == null || religion.isBlank()) {
            throw new ValidationException("religion could not be empty");
        }
        religions.add(religion);
    }

    public void addReligions(Set<String> religions) {
        if (religions.contains(null) || religions.stream().anyMatch(x -> x == null || x.isBlank())) {
            throw new ValidationException("religion could not be empty");
        } else {
            this.religions.addAll(religions);
        }
    }

    public void removeReligion(String religion) {
        if (this.religions.size() < 2) {
            throw new ValidationException("can not remove last religion");
        }
        religions.remove(religion);
    }

    ///////////////////////////////////////////////////////////////////////////////
    public List<String> getBaronies() {
        return Collections.unmodifiableList(this.baronies);
    }

    public void addBarony(String barony) {
        if (barony == null || barony.isBlank()) {
            throw new ValidationException("barony could not be empty");
        }
        baronies.add(barony);
    }

    public void addBaronies(List<String> baronies) {
        if (baronies.contains(null) || baronies.stream().anyMatch(x -> x == null || x.isBlank())) {
            throw new ValidationException("barony could not be empty");
        } else {
            this.baronies.addAll(baronies);
        }
    }

    public void removeBarony(String barony) {
        baronies.remove(barony);
    }

    ///////////////////////////////////////////////////////////////////////////////
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.isBlank()) {
            throw new ValidationException("Title could not be empty");
        }
        this.owner = owner;
    }

    /////////////////////////////////////////////////////////////////////////////////
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        if (dateOfCreation == null) {
            throw new ValidationException("Date of creation could not be empty");
        }
        this.dateOfCreation = dateOfCreation;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new ValidationException("Title could not be empty");
        }
        this.title = title;
    }
//////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public String toString() {
        return  "Title " + title + "\n" +
                "DateOfCreation " + dateOfCreation + "\n" +
                "Owner " + owner + "\n" +
                "Religions " + religions + "\n" +
                "Baronies " + baronies + "\n" +
                "FormOfGovernment " + formOfGovernment + "\n" +
                "Budget " + budget + "\n" +
                "Income " + income + "\n" +
                "Location " + location + "\n";
    }
}

