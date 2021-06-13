package pja.edu.s18591.Attribute.module;
import pja.edu.s18591.Attribute.exception.ValidationException;

public class Church {
    private String name;
    private static int minCost = 5000;
    private int cost;

    public Church(String name, int cost) {
        setName(name);
        setCost(cost);
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

    public static int getMinCost() {
        return minCost;
    }

    public static void setMinCost(int minCost) {
        Church.minCost = minCost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost < minCost){
            throw new ValidationException("cost could not be less then minimum cost");
        }
        this.cost = cost;
    }
}
