package Threads.TrafficSignalSimulation;

public enum TrafficEnum {
    RED(3000),
    YELLOW(1000),
    GREEN(2000);

    private final int waitTime;

    TrafficEnum(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getWaitTime() {
        return this.waitTime;
    }
}
