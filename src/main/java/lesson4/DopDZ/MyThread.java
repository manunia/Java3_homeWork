package lesson4.DopDZ;

import java.io.IOException;

public class MyThread implements Runnable {

    private MyFile myFile = new MyFile();

    @Override
    public void run() {
        try {
            myFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
