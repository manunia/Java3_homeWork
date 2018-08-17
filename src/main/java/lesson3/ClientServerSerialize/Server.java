package lesson3.ClientServerSerialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args){
        new Server();
    }

    private ServerSocket serv = null;
    private Socket sock = null;

    public Server(){
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения ...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
                try {
                    Student s2 = (Student) ois.readObject();
                    ois.close();
                    System.out.println("Object " + s2.getClass().getName() + " was deserialized.\n");
                    s2.info();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String str = sc.nextLine();
                if (str.equals("end")) break;
                System.out.println(str);
                pw.println("Эхо: " + str);
                pw.flush();
            }
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
