package lab3;

import Model.*;
import Serialize.JsonSerialize;
import Serialize.TxtSerialize;
import Serialize.XmlSerialize;

import java.io.IOException;
import java.util.*;

public class lab3Main {
    public static void main(String[] args) {
        System.out.println("=====================================Collections======================================");
        ArrayList<Bakery> bakeries = new ArrayList<>();

        for (int i = 0; i < 5; ++i)
            bakeries.add(generateBakery());

        for (Bakery bakery : bakeries)
            System.out.println(bakery);

        Collections.sort(bakeries);
        System.out.println();

        for (Bakery bakery : bakeries)
            System.out.println(bakery);
        System.out.println("======================================================================================");
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
