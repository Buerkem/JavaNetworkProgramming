package Threads;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            try {
                System.out.println("Thread is running...");
                Thread.sleep(4000);
                System.out.println("Thread completed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        myThread.start();
        try {
            //Let myThread complete before main thread resumes
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread resumes after myThread completes.");
    }
}
