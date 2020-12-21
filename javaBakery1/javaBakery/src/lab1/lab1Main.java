package lab1;

import Model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class lab1Main {
    public static void main(String[] args) {
        System.out.println("========================================Models========================================");
        System.out.println("Ingredient:");
        Ingredient ingredient = generateIngredient();
        System.out.println(ingredient);

        System.out.println("Purchase:");
        Purchase purchase = generatePurchase();
        System.out.println(purchase);

        System.out.println("CompositionOfProducts:");
        CompositionOfProducts compositionOfProducts = generateCompositionOfProducts();
        System.out.println(compositionOfProducts);

        System.out.println("Bakery:");
        Bakery bakery = generateBakery();
        System.out.println(bakery);

        System.out.println("Production:");
        Production production = generateProduction();
        System.out.println(production);

        System.out.println("======================================================================================");
    }

    public static Production generateProduction() {
        return new Production.Builder()
                .withBakery(generateBakery())
                .withCount(randInt(100, 1000))
                .withProductionDate(new Date())
                .build();
    }

    public static Bakery generateBakery() {
        ArrayList<CompositionOfProducts> compositionOfProducts = new ArrayList<CompositionOfProducts>();
        for (int i = 0; i < 10; ++i)
            compositionOfProducts.add(generateCompositionOfProducts());
        return new Bakery.Builder()
                .withCompositionOfProducts(compositionOfProducts)
                .withEnergyValue(randInt(100, 1000))
                .withName("Bakery")
                .withOptPrice(randInt(10, 1000))
                .withShelfLife(randInt(10, 100))
                .withWeight(randInt(10, 1000))
                .build();
    }

    public static Purchase generatePurchase() {
        return new Purchase.Builder()
                .withIngredient(generateIngredient())
                .withDateOfBuying(new Date(2020, Calendar.DECEMBER, 1))
                .withCount(randInt(1500, 10000))
                .build();
    }

    public static CompositionOfProducts generateCompositionOfProducts() {
        return new CompositionOfProducts.Builder()
                .withIngredient(generateIngredient())
                .withCount(randInt(1500, 10000))
                .build();
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
