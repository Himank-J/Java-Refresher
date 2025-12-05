package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableFactMain {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);


        CallableFact task1 = new CallableFact(2);
        CallableFact task2 = new CallableFact(5);
        CallableFact task3 = new CallableFact(8);

        Future<Double> output1 = executor.submit(task1);
        Future<Double> output2 = executor.submit(task2);
        Future<Double> output3 = executor.submit(task3);
        
        System.out.println(output1.get());
        System.out.println(output2.get());
        System.out.println(output3.get());

        executor.shutdown();

        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Closing immediately");
            executor.shutdownNow();
        }
    }
}
