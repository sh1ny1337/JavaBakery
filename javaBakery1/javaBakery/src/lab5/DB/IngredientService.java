package lab5.DB;

import Model.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

class IngredientService {

    private final Connection connection;

    private String name;
    private Integer quantityInStock;
    private Date validityPeriod;
    private Integer energyValue;
    private Integer price;

    IngredientService(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE  TABLE IF NOT EXISTS `bakery`.`ingredient` (" +
                "  `ingredient_id` INT NOT NULL," +
                "  `name` VARCHAR(50)," +
                "  `quantityInStock` INT," +
                "  `validityPeriod` DATE," +
                "  `energyValue` INT," +
                "  `price` INT," +
                "  PRIMARY KEY (`ingredient_id`) )");
    }

    ArrayList<Ingredient> getIngredients() throws SQLException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `bakery`.`ingredient`");

        while (set.next()) {
            Ingredient ingredient = new Ingredient.Builder()
                    .withQuantityInStock(set.getInt("quantityInStock"))
                    .withPrice(set.getInt("price"))
                    .withValidityPeriod(set.getDate("validityPeriod"))
                    .withName(set.getString("name"))
                    .withEnergyValue(set.getInt("energyValue"))
                    .build();
            ingredient.setId(set.getInt("ingredient_id"));
            ingredients.add(ingredient);
        }

        return ingredients;
    }

    void insertIngredient(Ingredient ingredient) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `bakery`.`ingredient`");
        int idAddress = 0;
        while (set.next()) {
            idAddress = set.getInt("ingredient_id");
        }
        ++idAddress;
        String sql = "INSERT INTO `bakery`.`ingredient`" +
                " ( `ingredient_id`, `name`, `quantityInStock`, `validityPeriod`, `energyValue`, `price` ) " +
                "VALUES " +
                "('" + idAddress + "', '" + ingredient.getName() + "', '" + ingredient.getQuantityInStock() +
                "', '" + convertDate(ingredient.getValidityPeriod()) + "', '" + ingredient.getEnergyValue() +
                "', '" + ingredient.getPrice() + "')";
        statement.executeUpdate(sql);
    }

    void updateIngredient(Ingredient ingredient) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "UPDATE `bakery`.`ingredient`" +
                "\n SET \n"+
                " name = \"" + ingredient.getName() +
                "\",\n quantityInStock = " + ingredient.getQuantityInStock() +
                ", \n validityPeriod = " + convertDate(ingredient.getValidityPeriod()) +
                ", \n energyValue = " + ingredient.getEnergyValue() +
                ", \n price = " + ingredient.getPrice() +
                "\n where ingredient_id = " + ingredient.getId() + ";";
        statement.executeUpdate(sql);
    }

    void deleteIngredient(Ingredient ingredient) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "DELETE FROM `bakery`.`ingredient` where ingredient_id = " + ingredient.getId()+";";
        statement.executeUpdate(sql);
    }

    void clearIngredient() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table `bakery`.`ingredient`");
    }

    private static String convertDate(Date uDate) {
        return uDate.getYear() + "-" + uDate.getMonth() + "-"+ uDate.getDay();
    }
}
