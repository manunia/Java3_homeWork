package lesson3.ClientServerSerialize;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Throwable {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Client();
                } catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        });
        thread1.start();

    }

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket sock;
    private Scanner sc;
    private PrintWriter out;

    public Client() throws Throwable {
        sock = new Socket(SERVER_ADDR, SERVER_PORT);
        Student s = new Student("Petr",50,15);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream())))
        {
            //send message to server
            while (true) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
                oos.writeObject(s);
                oos.close();
                if (new File("stud.ser").exists()){
                    System.out.println("Object " + s.getClass().getName() + " was serialized.\n");
                }
                sc = new Scanner(System.in);
                System.out.println("client: ");
                writer.write("client: " + sc.nextLine());
                writer.newLine();
                writer.flush();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //get message from server
                            System.out.println(reader.readLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                thread.start();
            }
        }


    }

}
