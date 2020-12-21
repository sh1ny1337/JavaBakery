package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class PersonService {
/*
    private final Connection connection;

    PersonService(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE  TABLE IF NOT EXISTS `organisation`.`person` (" +
                "  `person_id` INT NOT NULL," +
                "  `name` VARCHAR(50)," +
                "  `surname` VARCHAR(50)," +
                "  `fatherName` VARCHAR(50)," +
                "  `qualification` VARCHAR(50)," +
                "  `age` INT," +
                "  `height` INT," +
                "  `weight` INT," +
                "  PRIMARY KEY (`person_id`) )");
    }

    ArrayList<Person> getPeople() throws SQLException {
        ArrayList<Person> people = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `organisation`.`person`");

        while (set.next()) {
            Person person = new Person.Builder()
                    .withName(set.getString("name"))
                    .withSurname(set.getString("surname"))
                    .withFatherName(set.getString("fatherName"))
                    .withAge(set.getInt("age"))
                    .withHeight(set.getInt("height"))
                    .withWeight(set.getInt("weight"))
                    .build();
            person.setQualification(set.getString("qualification"));
            people.add(person);
        }

        return people;
    }

    void insertPerson(Person person) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `organisation`.`person`");
        int idPerson = 0;
        while (set.next()) {
            ++idPerson;
        }
        ++idPerson;
        String sql = "INSERT INTO `organisation`.`person`" +
                " ( `person_id`, `name`, `surname`, `fatherName`, `qualification`, `age`, `height`, `weight` ) " +
                "VALUES " +
                "('" + idPerson + "', '" + person.getName() + "', '" + person.getSurname() + "', '" + person.getFatherName() +
                "', '" + person.getQualification().toString() + "', '" + person.getAge() + "', '" + person.getHeight() +
                "','" + person.getWeight() + "')";
        statement.executeUpdate(sql);
    }

    void clearPerson() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table `organisation`.`person`");
    }*/
}
