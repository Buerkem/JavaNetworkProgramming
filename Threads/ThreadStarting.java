package Threads;

public class ThreadStarting {
    public static void main(String[] args){
        Thread hr = new Thread(new HelloRunnable());
        hr.start();

        Thread t = new HelloThread();
        t.start();
    }
}
