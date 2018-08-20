package lesson4.MFU;

public class Printer implements Runnable{
    Q q;

    public Printer(Q q) {
        this.q = q;
        new Thread(this,"Printer").start();
    }

    public void run() {
        int i = 0;
        while (true){
            q.print(i++);
        }
    }
}
