package lesson4.MFU;

public class Q {

    int n;
    boolean scanSet = false;

    synchronized int scan() {
        while (!scanSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        try {
            Thread.sleep(50);
            System.out.println("Отсканировано : " + n + " страниц");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scanSet = false;
        notify();
        return n;
    }

    synchronized void print(int n) {
        while (scanSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        this.n = n;
        scanSet = true;
        try {
            Thread.sleep(50);
            System.out.println(" Напечатано : " + n + " страниц");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}
