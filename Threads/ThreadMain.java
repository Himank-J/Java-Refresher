package Threads;

class ThreadBasic implements Runnable{
    
    public void run() {
        System.out.printf("Started Thread %s\n", Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Ended Thread - %s\n", Thread.currentThread().getName());
    }
}

public class ThreadMain  {
    public static void main(String[] args) throws InterruptedException {
        ThreadBasic task = new ThreadBasic();

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");
        Thread t3 = new Thread(task, "Thread-C");

        t1.start();
        t1.join();
        
        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }
}
