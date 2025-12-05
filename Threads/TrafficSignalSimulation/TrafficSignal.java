package Threads.TrafficSignalSimulation;

public class TrafficSignal {
    private TrafficEnum signalEnum;

    TrafficSignal (TrafficEnum signalEnum) {
        this.signalEnum = signalEnum;
    }

    public synchronized void showRed() {
        while (!this.signalEnum.equals(TrafficEnum.RED)) {
            try {
                System.out.println("🔴 RED signal waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
        System.out.println("🔴 RED signal ON");
       
        try { 
            Thread.sleep(this.signalEnum.getWaitTime()); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }

        this.signalEnum = TrafficEnum.GREEN;
        System.out.println("🔴 RED signal OFF");
        notifyAll();
    }

    public synchronized void showGreen() {
        while (!this.signalEnum.equals(TrafficEnum.GREEN)) {
            try {
                System.out.println("🟢 GREEN signal waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
        System.out.println("🟢 GREEN signal ON");
       
        try { 
            Thread.sleep(this.signalEnum.getWaitTime()); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }

        this.signalEnum = TrafficEnum.YELLOW;
        System.out.println("🟢 GREEN signal OFF");
        notifyAll();
    }

    public synchronized void showYellow() {
        while (!this.signalEnum.equals(TrafficEnum.YELLOW)) {
            try {
                System.out.println("🟡 YELLOW signal waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
        System.out.println("🟡 YELLOW signal ON");
       
        try { 
            Thread.sleep(this.signalEnum.getWaitTime()); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }

        this.signalEnum = TrafficEnum.RED;
        System.out.println("🟡 YELLOW signal OFF");
        notifyAll();
    }
}

class RedSignal implements Runnable {
    private final TrafficSignal signal;

    RedSignal (TrafficSignal signal) {
        this.signal = signal;
    }

    public void run() {
        while (true) {
            this.signal.showRed();
        }
    }
}

class GreenSignal implements Runnable {
    private final TrafficSignal signal;

    GreenSignal (TrafficSignal signal) {
        this.signal = signal;
    }

    public void run() {
        while (true) {
            this.signal.showGreen();
        }
    }
}

class YellowSignal implements Runnable {
    private final TrafficSignal signal;

    YellowSignal (TrafficSignal signal) {
        this.signal = signal;
    }

    public void run() {
        while (true) {
            this.signal.showYellow();
        }
    }
}