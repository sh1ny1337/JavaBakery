package Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class Purchase implements Comparable<Purchase> {
    /**
     * Класс закупки
     */
    @NotNull(message = "Ingredient cannot be null")
    private Ingredient ingredient;
    @Min(value = 0, message = "Count should not be less than 0")
    private Integer count;
    @NotNull(message = "DateOfBuying cannot be null")
    private Date dateOfBuying;

    @Override
    public int compareTo(Purchase o) {
        if (this.ingredient.compareTo(o.ingredient) != 0)
            return this.ingredient.compareTo(o.ingredient);
        if (this.count.compareTo(o.count) != 0)
            return this.count.compareTo(o.count);
        if (this.dateOfBuying.compareTo(o.dateOfBuying) != 0)
            return this.dateOfBuying.compareTo(o.dateOfBuying);
        return 0;
    }

    public static class Builder {
        private Purchase newPurchase;

        public Builder() {
            newPurchase = new Purchase();
        }

        public Builder withIngredient(Ingredient ingredient) {
            newPurchase.setIngredient(ingredient);
            return this;
        }

        public Builder withCount(Integer count) {
            newPurchase.setCount(count);
            return this;
        }

        public Builder withDateOfBuying(Date dateOfBuying) {
            newPurchase.setDateOfBuying(dateOfBuying);
            return this;
        }


        public Purchase build() {
            return newPurchase;
        }
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "ingredient=" + ingredient +
                ", count=" + count +
                ", dateOfBuying=" + dateOfBuying +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(ingredient, purchase.ingredient) &&
                Objects.equals(count, purchase.count) &&
                Objects.equals(dateOfBuying, purchase.dateOfBuying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, count, dateOfBuying);
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

    public Date getDateOfBuying() {
        return dateOfBuying;
    }

    public void setDateOfBuying(Date dateOfBuying) {
        this.dateOfBuying = dateOfBuying;
    }
}
