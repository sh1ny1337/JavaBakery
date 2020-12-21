package Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class Production implements Comparable<Production> {
    /**
     * Класс виробництва
     */
    @NotNull(message = "Bakery cannot be null")
    private Bakery bakery;
    @Min(value = 0, message = "Count should not be less than 0")
    private Integer count;
    @NotNull(message = "ProductionDate cannot be null")
    private Date productionDate;

    @Override
    public int compareTo(Production o) {
        if (this.bakery.compareTo(o.bakery) != 0)
            return this.bakery.compareTo(o.bakery);
        if (this.count.compareTo(o.count) != 0)
            return this.count.compareTo(o.count);
        if (this.productionDate.compareTo(o.productionDate) != 0)
            return this.productionDate.compareTo(o.productionDate);
        return 0;
    }

    public static class Builder {
        private Production newProduction;

        public Builder() {
            newProduction = new Production();
        }

        public Builder withBakery(Bakery bakery) {
            newProduction.setBakery(bakery);
            return this;
        }

        public Builder withCount(Integer count) {
            newProduction.setCount(count);
            return this;
        }

        public Builder withProductionDate(Date productionDate) {
            newProduction.setProductionDate(productionDate);
            return this;
        }

        public Production build() {
            return newProduction;
        }
    }

    public Bakery getBakery() {
        return bakery;
    }

    public void setBakery(Bakery bakery) {
        this.bakery = bakery;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Production{" +
                "bakery=" + bakery +
                ", count=" + count +
                ", productionDate=" + productionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Production that = (Production) o;
        return Objects.equals(bakery, that.bakery) &&
                Objects.equals(count, that.count) &&
                Objects.equals(productionDate, that.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bakery, count, productionDate);
    }
}
