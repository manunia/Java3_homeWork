package lesson4.MFU;

public class Scanner implements Runnable{
    Q q;

    public Scanner(Q q) {
        this.q = q;
        new Thread(this,"Scanner").start();
    }

    @Override
    public void run() {
        while (true){
            q.scan();
        }
    }
}
