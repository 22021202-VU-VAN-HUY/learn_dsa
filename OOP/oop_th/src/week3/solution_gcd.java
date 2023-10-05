package week3;

public class solution_gcd {
    /**
     * gcd max of a and b.
     *
     * @param a number 1
     * @param b number 2
     * @return gcd max
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(a % b, b);
    }

    public static void main(String[] args) {
        int a = -10;
        int b = 6;
        System.out.println(gcd(a, b));
        System.out.println(Integer.MAX_VALUE);
    }
}


