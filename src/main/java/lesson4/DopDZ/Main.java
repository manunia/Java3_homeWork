package lesson4.DopDZ;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myThreads();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File file = new File("123/8.txt");
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private static String str = "Зимой и летом одним цветом";

    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    public static void createFile() throws IOException{
        file.createNewFile();
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 100; i++) {
            bufferedWriter.write(i + ". " + str + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    
    public static void myThreads() throws IOException{
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }


}
