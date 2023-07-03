package Threads;

/*
The Thread.sleep() method is a convenience method provided by the Thread class itself.
It allows you to pause the execution of the current thread without explicitly creating a Thread object.
When you call Thread.sleep() within a program, it affects the execution of the current thread.
In the case of the example provided, the main() method runs on the main thread,
and calling Thread.sleep() pauses the execution of the main thread for the specified duration.
 */
public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Before sleep");

        try {
            // Pause execution for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After sleep");
    }
}

