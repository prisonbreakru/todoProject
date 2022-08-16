package uz.pdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DatabaseInit {

    default Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/todo_project",
                    "postgres",
                    "34plt34"
            );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
