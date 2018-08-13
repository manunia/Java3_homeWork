package lesson2;

import java.sql.*;
import java.util.Scanner;

/**
 * Maria L
 */
public class Main {

    private static Connection connection;
    private static Statement state;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            connect();
//          1.
            creaeTable();
//          2.
            insertProducts();
//          3.
            getCost();
//          4.
            changeCost();
//          5.
            selectProductsToCost();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                diconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        state = connection.createStatement();
    }

    public static void diconnect() throws SQLException {
        connection.close();
    }

    //1.Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
//  id – порядковый номер записи, первичный ключ;
//  prodid – уникальный номер товара;
//  title – название товара;
//  cost – стоимость.
    public static void creaeTable() throws ClassNotFoundException, SQLException {
        state.executeUpdate("CREATE TABLE IF NOT EXISTS Products\n" +
                "(\n" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "ProductID INTEGER NOT NULL,\n" +
                "Title TEXT NOT NULL,\n" +
                "Cost INTEGER NOT NULL);");
    }

    //2. При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
//   id_товара 1 товар1 10
//   id_товара 2 товар2 20
//   id_товара 3 товар3 30
//   id_товара 10000 товар10000 100000
    public static void insertProducts() throws ClassNotFoundException, SQLException {
        state.executeUpdate("DELETE FROM Products");
        connection.setAutoCommit(false);
        for (int i = 1; i <= 10000; i++) {
            state.executeUpdate("INSERT INTO Products (ProductID, Title, Cost)\n" +
                    "VALUES (" + i + ",'товар" + i + "',"+ i*10+ ")");
        }
        connection.setAutoCommit(true);
    }

    //3.Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо
//  вывести сообщение «Такого товара нет», если товар не обнаружен в базе. Консольная
//  команда: «цена товар545».
    public static void getCost() throws ClassNotFoundException, SQLException {
        String consoleCommand1 = scanner.nextLine();
        String producTitle[] = consoleCommand1.split("\\s");
        if (producTitle[0].equals("цена")){
            ResultSet rs = state.executeQuery("SELECT Cost FROM Products WHERE Title = " + "'" + producTitle[1] + "'");
            if (rs.next()){
                System.out.println(rs.getInt(1));
            } else {
                System.out.println("Такого товара нет");
            }
        }
    }

    //4. Добавить возможность изменения цены товара. Указываем имя товара и новую цену.
//   Консольная команда: «сменитьцену товар10 10000».
    public static void changeCost() throws ClassNotFoundException, SQLException{
        String consoleCommand2 = scanner.nextLine();
        String changeCost[] = consoleCommand2.split("\\s");
        if (changeCost[0].equals("сменитьцену")){
            state.executeUpdate("UPDATE Products SET Cost = '" +  changeCost[2] + "'" +
                    "WHERE Title = '" + changeCost[1] + "'");
        }
    }

//  Вывести товары в заданном ценовом диапазоне. Консольная команда:
// «товарыпоцене 100 600»
    public static void selectProductsToCost() throws ClassNotFoundException, SQLException {
        String consoleCommand3 = scanner.nextLine();
        String selectProd[] = consoleCommand3.split("\\s");
        if (selectProd[0].equals("товарыпоцене")){
            ResultSet rs = state.executeQuery("SELECT Title FROM Products WHERE Cost > '" + selectProd[1] + "' AND Cost < ' " + selectProd[2] + "'");
            while (rs.next()){
                System.out.println(rs.getString("Title"));
            }
        }
    }

}
