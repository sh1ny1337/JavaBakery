import DB.DBConnection;
import Model.*;
import Serialize.JsonSerialize;
import Serialize.TxtSerialize;
import Serialize.XmlSerialize;


import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        checkModels();

        checkSerialize();

        checkCollections();

        checkDBConnection();

        System.out.println("======================================================================================");
    }

    public static void checkDBConnection(){
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

    public static void checkCollections(){
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

    public static void checkSerialize() {
        System.out.println("=======================================Serialize======================================");
        Bakery bakery = generateBakery();
        System.out.println(bakery);
        System.out.println("JSON serialize:");
        JsonSerialize jsonSerialize = new JsonSerialize();
        try {
            jsonSerialize.serialize(bakery, "bakery.json");
            Bakery bakery1 = jsonSerialize.deserialize("bakery.json");
            System.out.println(bakery1);
            System.out.println("Compare: " + bakery.compareTo(bakery1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("XML serialize:");
        XmlSerialize xmlSerialize = new XmlSerialize();
        try {
            xmlSerialize.serialize(bakery, "bakery.xml");
            Bakery bakery2 = xmlSerialize.deserialize("bakery.xml");
            System.out.println(bakery2);
            System.out.println("Compare: " + bakery.compareTo(bakery2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Txt serialize:");
        TxtSerialize txtSerialize = new TxtSerialize();
        try {
            txtSerialize.serialize(bakery, "bakery.txt");
            Bakery bakery3 = txtSerialize.deserialize("bakery.txt");
            System.out.println(bakery3);
            System.out.println("Compare: " + bakery.compareTo(bakery3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======================================================================================");
    }

    public static void checkModels() {
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
