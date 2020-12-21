package lab4;

import Model.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class lab4Main {
    public static void main(String[] args) {

        System.out.println("======================================Validation======================================");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        System.out.println("Ingredient:");
        Ingredient ingredient = generateIngredient();
        if (validator.validate(ingredient).size() > 0)
            for (ConstraintViolation<Ingredient> string : validator.validate(ingredient))
                System.out.println(string);
        else
            System.out.println(ingredient);

        System.out.println("Ingredient:");
        Ingredient ingredient1 = new Ingredient();
        if (validator.validate(ingredient1).size() > 0)
            for (ConstraintViolation<Ingredient> string : validator.validate(ingredient1))
                System.out.println(string);
        else
            System.out.println(ingredient1);

        System.out.println("======================================================================================");

        System.out.println("Purchase:");
        Purchase purchase = generatePurchase();
        if (validator.validate(purchase).size() > 0)
            for (ConstraintViolation<Purchase> string : validator.validate(purchase))
                System.out.println(string);
        else
            System.out.println(purchase);

        System.out.println("Purchase:");
        Purchase purchase1 = new Purchase();
        if (validator.validate(purchase1).size() > 0)
            for (ConstraintViolation<Purchase> string : validator.validate(purchase1))
                System.out.println(string);
        else
            System.out.println(purchase1);

        System.out.println("======================================================================================");

        System.out.println("CompositionOfProducts:");
        CompositionOfProducts compositionOfProducts = generateCompositionOfProducts();
        if (validator.validate(compositionOfProducts).size() > 0)
            for (ConstraintViolation<CompositionOfProducts> string : validator.validate(compositionOfProducts))
                System.out.println(string);
        else
            System.out.println(compositionOfProducts);
        System.out.println("CompositionOfProducts:");
        CompositionOfProducts compositionOfProducts1 = new CompositionOfProducts();
        if (validator.validate(compositionOfProducts1).size() > 0)
            for (ConstraintViolation<CompositionOfProducts> string : validator.validate(compositionOfProducts1))
                System.out.println(string);
        else
            System.out.println(compositionOfProducts1);

        System.out.println("======================================================================================");

        System.out.println("Bakery:");
        Bakery bakery = generateBakery();
        if (validator.validate(bakery).size() > 0)
            for (ConstraintViolation<Bakery> string : validator.validate(bakery))
                System.out.println(string);
        else
            System.out.println(bakery);

        System.out.println("Bakery:");
        Bakery bakery1 = new Bakery();
        if (validator.validate(bakery1).size() > 0)
            for (ConstraintViolation<Bakery> string : validator.validate(bakery1))
                System.out.println(string);
        else
            System.out.println(bakery1);

        System.out.println("======================================================================================");

        System.out.println("Production:");
        Production production = generateProduction();
        if (validator.validate(production).size() > 0)
            for (ConstraintViolation<Production> string : validator.validate(production))
                System.out.println(string);
        else
            System.out.println(production);

        System.out.println("Production:");
        Production production1 = new Production();
        if (validator.validate(production1).size() > 0)
            for (ConstraintViolation<Production> string : validator.validate(production1))
                System.out.println(string);
        else
            System.out.println(production1);

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
