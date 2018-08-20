package lesson4.MFU;

public class Q {

    int n;
    boolean valueSet = false;

    synchronized int scan() {
        while (!valueSet) {
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
        valueSet = false;
        notify();
        return n;
    }

    synchronized void print(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        this.n = n;
        valueSet = true;
        try {
            Thread.sleep(50);
            System.out.println(" Напечатано : " + n + " страниц");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}
