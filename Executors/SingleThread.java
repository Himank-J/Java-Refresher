package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            for (int i=1; i<=10; i++) {
                System.out.println(i);
            }
        };

        executor.submit(task);
        executor.shutdown();
    }
}