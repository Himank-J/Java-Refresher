package Executors;

import java.util.concurrent.Callable;

public class CallableFact implements Callable<Double>{
    
    private double num;
    CallableFact(double num) {
        this.num = num;
    }

    public Double call() throws Exception {        
        System.out.println("Calculating factorial for " + this.num);  
        double fact = calculateFactorial(this.num);
        return fact;
    }

    public double calculateFactorial(double num) {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            return num * calculateFactorial(num-1);
        }
    }
}
