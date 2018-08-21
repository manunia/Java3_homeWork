package lesson4.DopDZ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            MyFile.createFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            MyFile.readFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new MyThread()));
        }
        for (Thread thread:threads) {
            thread.start();
        }

        for (Thread tread:threads) {
            try {
                tread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
