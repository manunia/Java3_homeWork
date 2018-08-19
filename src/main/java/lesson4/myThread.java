package lesson4;

import java.io.*;

public class myThread {
    public static void main(String[] args) {
        //1.
        threeLetters();
    }

//    1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз,
//    порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
    public static void threeLetters() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.print("B");
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.print("C");
                }
            }
        });
        t3.start();
    }

//    2. Написать совсем небольшой метод,
//    в котором 3 потока построчно пишут данные в файл
//            (штук по 10 записей, с периодом в 20 мс)
    private static File file = new File("123/7.txt");
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private static String str = "Hello World!";

    public static void writeTiFile() throws IOException {
        file.createNewFile();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fileWriter = new FileWriter(file);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    for (int i = 0; i < 10; i++) {
                        bufferedWriter.write(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            t1.wait(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

    }
}
