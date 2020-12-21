package lab1.Classes;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CompositionOfProducts implements Comparable<CompositionOfProducts> {
    /**
     * Класс к-сті інгрідієнтів
     */
    @NotNull(message = "Ingredient cannot be null")
    private Ingredient ingredient;
    @Min(value = 0, message = "Count should not be less than 0")
    private Integer count;

    @Override
    public int compareTo(CompositionOfProducts o) {
        if (this.ingredient.compareTo(o.ingredient) != 0)
            return this.ingredient.compareTo(o.ingredient);
        if (this.count.compareTo(o.count) != 0)
            return this.count.compareTo(o.count);
        return 0;
    }

    public static class Builder {
        private CompositionOfProducts newCompositionOfProducts;

        public Builder() {
            newCompositionOfProducts = new CompositionOfProducts();
        }

        public Builder withIngredient(Ingredient ingredient) {
            newCompositionOfProducts.setIngredient(ingredient);
            return this;
        }

        public Builder withCount(Integer count) {
            newCompositionOfProducts.setCount(count);
            return this;
        }

        public CompositionOfProducts build() {
            return newCompositionOfProducts;
        }
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "ingredient=" + ingredient +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionOfProducts purchase = (CompositionOfProducts) o;
        return Objects.equals(ingredient, purchase.ingredient) &&
                Objects.equals(count, purchase.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, count);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
