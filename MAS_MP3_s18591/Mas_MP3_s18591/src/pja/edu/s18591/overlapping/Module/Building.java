package pja.edu.s18591.overlapping.Module;

import pja.edu.s18591.multi.exception.ValidationException;
import pja.edu.s18591.overlapping.Interface.Library;
import pja.edu.s18591.overlapping.Interface.Storage;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Building implements Library, Storage {
    private String name;
    private Integer books;
    private Integer items;

    private EnumSet<BuildingType> types;

    public Building(EnumSet<BuildingType> types, String name,
                    Integer books,Integer items) {
        setTypes(types);
        setName(name);
        if(isLibrary()){
            setBooks(books);
        }
        if(isStorage()){
            setItems(items);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new ValidationException("name could not be empty");
        }
        this.name = name;
    }

    @Override
    public int getBooks() {
        if(!isLibrary()){
            throw new ValidationException("not library");
        }
        return books;
    }

    public void setBooks(int books) {
        if(!isLibrary()){
            throw new ValidationException("not library");
        }
        this.books = books;
    }

    @Override
    public int getItems() {
        if(!isStorage()){
            throw new ValidationException("not storage");
        }
        return items;
    }

    public void setItems(int items) {
        if(!isStorage()){
            throw new ValidationException("not storage");
        }
        this.items = items;
    }

    public Set<BuildingType> getTypes() {
        return new HashSet<>(types);
    }

    public void setTypes(EnumSet<BuildingType> types) {
        if(types == null){
            throw new ValidationException("Type could not be null");
        }
        this.types = types;
    }

    public boolean isLibrary(){
        return types.contains(BuildingType.LIBRARY);
    }
    public boolean isStorage(){
        return types.contains(BuildingType.STORAGE);
    }
}
