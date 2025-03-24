class runnableKullan implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable thread: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { }
        }
    }
}

public class ikinci {
    public static void main(String[] args) {
        Thread thread = new Thread(new runnableKullan()); // KULLANIMA DIKKAT ET
        thread.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}
