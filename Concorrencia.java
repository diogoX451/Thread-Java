public class Concorrencia extends Thread{
    public static int amount = 0;
    public static void main(String[] args) {
        Concorrencia thread  = new Concorrencia();

        thread.start();
        System.out.println("Concorrencia started: " + amount);
        amount++;
        System.out.println(
        "Concorrencia started: " + amount
        );
    }

    public void run() {
        amount++;
        System.out.println("Concorrencia started-new-thread: " + amount);
    }
}

