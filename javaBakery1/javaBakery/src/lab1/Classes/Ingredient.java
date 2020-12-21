package lab1.Classes;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class Ingredient implements Comparable<Ingredient> {
    /**
     * Класс інгрідієнт
     */
    private int id;/**Для бази даних*/
    @NotNull(message = "Name cannot be null")
    private String name;
    @Min(value = 0, message = "QuantityInStock should not be less than 0")
    private Integer quantityInStock;
    @NotNull(message = "ValidityPeriod cannot be null")
    private Date validityPeriod;
    @Min(value = 0, message = "EnergyValue number should not be less than 0")
    private Integer energyValue;
    @Min(value = 0, message = "Price number should not be less than 0")
    private Integer price;

    @Override
    public int compareTo(Ingredient o) {
        if (this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        if (this.quantityInStock.compareTo(o.quantityInStock) != 0)
            return this.quantityInStock.compareTo(o.quantityInStock);
        if (this.validityPeriod.compareTo(o.validityPeriod) != 0)
            return this.validityPeriod.compareTo(o.validityPeriod);
        if (this.energyValue.compareTo(o.energyValue) != 0)
            return this.energyValue.compareTo(o.energyValue);
        if (this.price.compareTo(o.price) != 0)
            return this.price.compareTo(o.price);
        return 0;
    }

    public static class Builder {
        private Ingredient newIngredient;

        public Builder() {
            newIngredient = new Ingredient();
        }

        public Builder withName(String name) {
            newIngredient.setName(name);
            return this;
        }

        public Builder withQuantityInStock(Integer quantityInStock) {
            newIngredient.setQuantityInStock(quantityInStock);
            return this;
        }

        public Builder withValidityPeriod(Date validityPeriod) {
            newIngredient.setValidityPeriod(validityPeriod);
            return this;
        }

        public Builder withEnergyValue(Integer energyValue) {
            newIngredient.setEnergyValue(energyValue);
            return this;
        }

        public Builder withPrice(Integer price) {
            newIngredient.setPrice(price);
            return this;
        }

        public Ingredient build() {
            return newIngredient;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Date getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Date validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", validityPeriod=" + validityPeriod +
                ", energyValue=" + energyValue +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(quantityInStock, that.quantityInStock) &&
                Objects.equals(validityPeriod, that.validityPeriod) &&
                Objects.equals(energyValue, that.energyValue) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantityInStock, validityPeriod, energyValue, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
