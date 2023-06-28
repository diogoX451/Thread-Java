class MinhaThread extends Thread {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getId() + " Valor: " + i);
        }
    }
}

public class Index {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread();
        t1.start();

        MinhaThread t2 = new MinhaThread();
        t2.start();
    }
}
