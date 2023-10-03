package week3;

public class Solution_prime {
    /**
     * @param n checkout prime.
     * @return true if n is prime, else return false
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(isPrime(n));
    }
}
