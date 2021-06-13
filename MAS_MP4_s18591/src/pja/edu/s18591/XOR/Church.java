package pja.edu.s18591.XOR;

import pja.edu.s18591.Attribute.exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Church {
    private String title;
    private List<Person> persons = new ArrayList<>();

    public Church(String title) {
       setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new ValidationException("title could not be empty");
        }
        this.title = title;
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public void AddPerson(Person person){
        if(person == null){
            throw new ValidationException("building could not be null");
        }
        if(person.getCounty() != null){
            throw new ValidationException("this person already assigned us subject of county");
        }
        if(this.persons.contains(person)){
            return;
        }
        this.persons.add(person);
        person.setChurch(this);
    }
    public void removePerson(Person person){
        if(person == null){
            throw new ValidationException("person could not be null");
        }
        if(!this.persons.contains(person)){
            return;
        }
        this.persons.remove(person);
        person.setChurch(null);
    }
}
