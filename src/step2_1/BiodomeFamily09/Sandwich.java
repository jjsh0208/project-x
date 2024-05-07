package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;

public class Sandwich extends  Menu{

    private String ingredients;
    private LocalDateTime expirationDate;
    public Sandwich(String name, int price,String ingredients ,LocalDateTime expirationDate) {
        super(name, price);
        this.ingredients =ingredients;
        this.expirationDate =expirationDate;
    }


    public String getIngredients() {
        return ingredients;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() +  ", " +"ingredients='" + ingredients + '\'' + ", expirationDate=" + expirationDate + '}';
    }
}
