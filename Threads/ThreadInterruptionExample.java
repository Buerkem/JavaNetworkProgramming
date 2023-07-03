package Threads;

public class ThreadInterruptionExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        });

        myThread.start();

        try {
            // Pause main thread for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread
        myThread.interrupt();
    }
}