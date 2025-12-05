package Functional_Interface;

public class PrimeMain {
    public static void main(String[] args) {
        PrimeInterface primeNum = (int num) -> {
            for (int i=2; i<num; i++) {
                if (num%i == 0) {
                    return false;
                }
            }
            return true;
        };

        System.out.println(primeNum.isPrime(7));
    }
}
