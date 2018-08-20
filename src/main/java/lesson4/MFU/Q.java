package lesson4.MFU;

public class Q {

    int n;

    synchronized int scan() {
        System.out.println(" Отсканировано : " + n);
        return n;
    }

    synchronized void print(int n) {
        this.n = n;
        System.out.println(" Напечатано : " + n);

    }
}
