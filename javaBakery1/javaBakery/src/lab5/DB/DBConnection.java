package lab5.DB;

import Model.Ingredient;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {


    private Connection connection;
   private final IngredientService ingredientService;

    public DBConnection() throws SQLException {
        connection = DBConnect.getConnect();
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS bakery;");

        ingredientService = new IngredientService(connection);
    }

    public ArrayList<Ingredient> getIngredients() throws SQLException {
        return ingredientService.getIngredients();
    }

    public void insertIngredient(Ingredient ingredient) throws SQLException {
        ingredientService.insertIngredient(ingredient);
    }

    public void updateIngredient(Ingredient ingredient) throws SQLException {
        ingredientService.updateIngredient(ingredient);
    }

    public void deleteIngredient(Ingredient ingredient) throws SQLException {
        ingredientService.deleteIngredient(ingredient);
    }

    public void clearIngredient() throws SQLException {
        ingredientService.clearIngredient();
    }

}
