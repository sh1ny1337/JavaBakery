package lab5;

import DB.DBConnection;
import Model.*;
import java.util.*;

public class lab5Main {
    public static void main(String[] args) {
        System.out.println("====================================DBConnection======================================");
        try {
            DBConnection db = new DBConnection();

            db.clearIngredient();

            System.out.println("------Ingredient------");
            for (int i = 0; i < 5; ++i)
                db.insertIngredient(generateIngredient());

            for (Ingredient ingredient : db.getIngredients()) {
                System.out.println(ingredient);
                ingredient.setName("NEW Ingredient - " + randInt(0, 100));

                db.updateIngredient(ingredient);
            }

            Ingredient ingredienti = db.getIngredients().get(0);
            db.deleteIngredient(ingredienti);

            for (Ingredient ingredient : db.getIngredients())
                System.out.println(ingredient);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======================================================================================");
    }

    public static Ingredient generateIngredient() {
        return new Ingredient.Builder()
                .withName("Ingredient")
                .withValidityPeriod(new Date(2021, Calendar.MARCH, 1))
                .withEnergyValue(randInt(100, 300))
                .withPrice(randInt(1500, 10000))
                .withQuantityInStock(randInt(1, 200))
                .build();
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
