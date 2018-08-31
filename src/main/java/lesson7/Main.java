package lesson7;

import lesson3.ClientServerSerialize.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Main {

    static Connection connection;
    static Statement stmt;

    public static void main(String[] args) throws SQLException {
        //prepareTable(Studdent.class);
        addObject(Studdent.class);
    }

    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void prepareTable(Class c) throws SQLException {
        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable missed");

        //поле int напишем как "INTEGER"
        HashMap<Class, String> hm = new HashMap<>();
        hm.put(int.class,"INTEGER");
        hm.put(String.class,"TEXT");

        try {
            connect();
            //узнаем имя таблицы
            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
            //если такая таблица есть, то удалим ее
            stmt.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");

            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";

            //получаем все поля из класса
            Field[] fields = c.getDeclaredFields();
            for (Field o: fields) {
                //если есть аннотация, то добавляем ее в таблицу
                if (o.isAnnotationPresent(XField.class)) {
                    query += o.getName() + " " + hm.get(o.getType()) + ", ";
                }
            }
            query = query.substring(0,query.length() - 2);
            query += ");";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addObject(Class c) throws SQLException {
        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable missed");

        //поле int напишем как "INTEGER"
        HashMap<Class, String> hm = new HashMap<>();
        hm.put(int.class,"INTEGER");
        hm.put(String.class,"TEXT");

        try {
            connect();
            //узнаем имя таблицы
            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();

            String query = "INSERT INTO " + tableName + " (";

            //получаем все поля из класса
            Field[] fields = c.getDeclaredFields();
            for (Field o: fields) {
                //если есть аннотация, то добавляем ее в таблицу
                if (o.isAnnotationPresent(XField.class)) {
                    query += o.getName() + ", ";
                }
            }
            query = query.substring(0,query.length() - 2);
            query += ") VALUES ( " + 1 + ", " + "'Ivanov_V'"+ ", " + 100 + ", " + "'ivanov@mail.ru'";
            query += ");";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }


}
