package lesson6;

import java.sql.*;
import java.util.ArrayList;

public class Table {

    public static void main(String[] args) {
        Table table = new Table();
//        try {
//            table.connect();
//            table.createTable();
//            table.insert("Bob1",11);
//            table.insert("Bob2",15);
//            table.insert("Bob3",19);
//            table.insert("Bob4",22);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            table.disconnect();
//        }
        try {
            System.out.println(table.read());
            table.read();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Connection connection;
    private static Statement statement;

    //3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл).
    // Написать тесты для проверки того, что при работе с базой корректно добавляются,
    // обновляются и читаются записи. Следует учесть что в базе есть заранее добавленные записи,
    // и после проведения тестов эти записи не должны быть удалены/изменены/добавлены.
    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main3.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createTable() throws SQLException {
        connect();
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Students\n" +
                    "(\n" +
                    "idStudent INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "FirstName TEXT NOT NULL,\n" +
                    "Mark INTEGER NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public String insert(String firstName, int mark) throws SQLException {
        connect();
        ArrayList<String> strings = new ArrayList<>();
        String sql = String.format("INSERT INTO Students (FirstName, Mark)\n" +
                "VALUES ('%s',%s)", firstName,mark);
        ResultSet rs = statement.executeQuery(sql);
        try {
            statement.execute(sql);
            while (rs.next()) {
                //System.out.println(rs.getString(2));
                strings.add(rs.getString(2));
            }
            return strings.get(strings.size()-1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public String read() throws SQLException {
        connect();
        String sql = String.format("SELECT * FROM STUDENTS");
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                //System.out.println(rs.getString(2));
                return rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
