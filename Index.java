class MinhaThread extends Thread {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getId() + " Valor: " + i);
        }
    }
}

// Em seguida, no método main ou em outro lugar adequado, inicie a thread
public class Index {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread();
        t1.start();

        MinhaThread t2 = new MinhaThread();
        t2.start();
    }
}