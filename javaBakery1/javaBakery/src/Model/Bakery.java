package Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Bakery implements Comparable<Bakery> {
    /**
     * Класс випічки
     */
    @NotNull(message = "CompositionOfProducts cannot be null")
    private ArrayList<CompositionOfProducts> compositionOfProducts;
    @NotNull(message = "Name cannot be null")
    private String name;
    @Min(value = 0, message = "QuantityInStock should not be less than 0")
    private Integer weight;
    @Min(value = 0, message = "ShelfLife should not be less than 0")
    private Integer shelfLife;
    @Min(value = 0, message = "EnergyValue number should not be less than 0")
    private Integer energyValue;
    @Min(value = 0, message = "OptPrice number should not be less than 0")
    private Integer optPrice;

    @Override
    public int compareTo(Bakery o) {
        if (this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        if (this.weight.compareTo(o.weight) != 0)
            return this.weight.compareTo(o.weight);
        if (this.shelfLife.compareTo(o.shelfLife) != 0)
            return this.shelfLife.compareTo(o.shelfLife);
        if (this.energyValue.compareTo(o.energyValue) != 0)
            return this.energyValue.compareTo(o.energyValue);
        if (this.optPrice.compareTo(o.optPrice) != 0)
            return this.optPrice.compareTo(o.optPrice);
        return 0;
    }

    public static class Builder {
        private Bakery newBakery;

        public Builder() {
            newBakery = new Bakery();
        }

        public Builder withCompositionOfProducts(ArrayList<CompositionOfProducts> compositionOfProducts) {
            newBakery.setCompositionOfProducts(compositionOfProducts);
            return this;
        }

        public Builder withName(String name) {
            newBakery.setName(name);
            return this;
        }

        public Builder withWeight(Integer weight) {
            newBakery.setWeight(weight);
            return this;
        }

        public Builder withShelfLife(Integer shelfLife) {
            newBakery.setShelfLife(shelfLife);
            return this;
        }

        public Builder withEnergyValue(Integer energyValue) {
            newBakery.setEnergyValue(energyValue);
            return this;
        }

        public Builder withOptPrice(Integer optPrice) {
            newBakery.setOptPrice(optPrice);
            return this;
        }

        public Bakery build() {
            return newBakery;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Integer getOptPrice() {
        return optPrice;
    }

    public void setOptPrice(Integer optPrice) {
        this.optPrice = optPrice;
    }

    public ArrayList<CompositionOfProducts> getCompositionOfProducts() {
        return compositionOfProducts;
    }

    public void setCompositionOfProducts(ArrayList<CompositionOfProducts> compositionOfProducts) {
        this.compositionOfProducts = compositionOfProducts;
    }

    @Override
    public String toString() {
        return "Bakery{" +
                "compositionOfProducts=" + compositionOfProducts +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", shelfLife=" + shelfLife +
                ", energyValue=" + energyValue +
                ", optPrice=" + optPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bakery bakery = (Bakery) o;
        return Objects.equals(compositionOfProducts, bakery.compositionOfProducts) &&
                Objects.equals(name, bakery.name) &&
                Objects.equals(weight, bakery.weight) &&
                Objects.equals(shelfLife, bakery.shelfLife) &&
                Objects.equals(energyValue, bakery.energyValue) &&
                Objects.equals(optPrice, bakery.optPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compositionOfProducts, name, weight, shelfLife, energyValue, optPrice);
    }
}
