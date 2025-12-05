package Threads;

class SharedResource {
    private boolean available = false;

    synchronized void produce() {
        System.out.println("Producer trying to produce...");
        while (available) {
            try {
                System.out.println("Producer: waiting...");
                wait(); // wait until consumer consumes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Produced item");
        available = true;
        notify(); // wake up waiting consumer
    }

    synchronized void consume() {
        System.out.println("Consumer trying to consume...");
        while (!available) {
            try {
                System.out.println("Consumer: waiting...");
                wait(); // wait until producer produces
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed item");
        available = false;
        notify(); // wake up waiting producer
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 2; i++) resource.produce();
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 2; i++) resource.consume();
        });

        producer.start();
        consumer.start();
    }
}

