package Traductor;

import java.sql.*;

public class Conexion {

    private Connection connection;

    public Conexion() {
        getConnection();
    }

    public void getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String host = "192.168.56.1";
            String dbname = "dbtraductor";
            String url = "jdbc:mariadb://" + host + "/" + dbname;
            String username = "traductor";
            String password = "toor";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha podido cargar el driver");
            e.printStackTrace();
        }
    }

    public void consultarDatos(String palabra) {
        try {
            if (!connection.isClosed()) {
                if (palabra.equals(SchemaDB.COL_ESPANOL.toLowerCase())) {
                    System.out.printf("%s", SchemaDB.COL_INGLES);
                } else {
                    System.out.println("palabra no encontrada");
                }
            } else {
                System.out.println("No se ha podido leer");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
