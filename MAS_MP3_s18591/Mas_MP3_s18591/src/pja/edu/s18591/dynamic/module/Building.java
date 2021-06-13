package pja.edu.s18591.dynamic.module;
import pja.edu.s18591.dynamic.Interface.Library;
import pja.edu.s18591.dynamic.Interface.WineCellar;
import pja.edu.s18591.multi.exception.ValidationException;

public class Building implements Library, WineCellar {
    private String name;
    private Integer books;
    private Float wine;

    private BuildingType type;

    public Building(String name,Integer books) {
        setName(name);
        setType(BuildingType.LIBRARY);
        if(isLibrary()){
            setBooks(books);
        }
    }

    public Building(String name,Float wine) {
        setName(name);
        setType(BuildingType.WineCellar);
        if(isStorage()){
            setWine(wine);
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
    public float getWine() {
        if(!isStorage()){
            throw new ValidationException("not storage");
        }
        return wine;
    }

    public void setWine(float wine) {
        if(!isStorage()){
            throw new ValidationException("not storage");
        }
        this.wine = wine;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        if(type == null){
            throw new ValidationException("type could be null");
        }
        this.type = type;
    }

    public boolean isLibrary(){
        return type == BuildingType.LIBRARY;
    }
    public boolean isStorage(){
        return type == BuildingType.WineCellar;
    }

    public void becomeLibrary(int books){
        this.type = BuildingType.LIBRARY;
        setBooks(books);
        this.wine = null;
    }

    public void becomeWineCellar(float wine){
        this.type = BuildingType.WineCellar;
        setWine(wine);
        this.books = null;
    }

}
