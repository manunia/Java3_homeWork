package lesson4;
/**
 * Maria_L
 */

import java.io.*;

public class myThread {
    public static void main(String[] args) {
        //1.
        threeLetters();
        //2.
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз,
//    порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
    static Object mon = new Object();
    static volatile char cL = 'A';
    public static void threeLetters() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (cL != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            cL = 'B';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (cL != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            cL = 'C';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (cL != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            cL = 'A';
                            mon.notifyAll();
                        }
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
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
    private static String str = "В лесу родилась елочка";

    public static synchronized void writeToFile() throws IOException {
        file.createNewFile();
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        try {
                            Thread.sleep(20);
                            bufferedWriter.write("t1." + i + ". " + str + "\n");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        try {
                            Thread.sleep(20);
                            bufferedWriter.write("t2." + i + ". " + str + "\n");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        try {
                            Thread.sleep(20);
                            bufferedWriter.write("t3." + i + ". " + str + "\n");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        System.out.println("Запись в файл окончена");
    }


}
