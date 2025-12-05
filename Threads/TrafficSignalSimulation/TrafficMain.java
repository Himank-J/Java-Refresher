package Threads.TrafficSignalSimulation;

public class TrafficMain {
    public static void main(String[] args) {
        // Single shared traffic signal starting with RED
        TrafficSignal sharedSignal = new TrafficSignal(TrafficEnum.RED);
        
        // Each thread uses the correct Runnable class and shares the same signal
        Thread red = new Thread(new RedSignal(sharedSignal), "RED");
        Thread green = new Thread(new GreenSignal(sharedSignal), "GREEN");
        Thread yellow = new Thread(new YellowSignal(sharedSignal), "YELLOW");

        red.start();
        green.start();
        yellow.start();
    }
}
