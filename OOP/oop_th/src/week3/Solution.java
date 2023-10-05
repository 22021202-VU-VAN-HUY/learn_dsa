package week3;

public class Solution {
    private int numerator;
    private int denominator;

    public Solution() {
    }

    /**
     * khai bao phan so.
     *
     * @param numerator   tu so
     * @param denominator mau so
     */
    public Solution(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            return;
        }

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     *  tim uoc chung lon nhat cua hai so nguyen.
     * @param a tu so
     * @param b mau so
     * @return uoc chung lon nhat cua hai so tren
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * rut gon phan so.
     */
    public void reduce() {
        int x = this.numerator;
        int y = this.denominator;
        this.numerator = x / gcd(x, y);
        this.denominator = y / gcd(x, y);
    }

    /**
     * cong 2 phan so.
     *
     * @param s2 phan so thu hai
     * @return ket qua cong duoc gan vao phan so thu nhat
     */
    public Solution add(Solution s2) {
        int x = this.numerator;
        int y = this.denominator;
        this.numerator = x * s2.denominator + y * s2.numerator;
        this.denominator = y * s2.denominator;
        reduce();
        return this;
    }

    /**
     * tru 2 phan so.
     *
     * @param s2 phan so thu hai
     * @return ket qua tru duoc gan vao phan so thu nhat
     */
    public Solution subtract(Solution s2) {
        int x = this.numerator;
        int y = this.denominator;
        this.numerator = x * s2.denominator - y * s2.numerator;
        this.denominator = y * s2.denominator;
        reduce();
        return this;
    }

    /**
     * nhan 2 phan so.
     *
     * @param s2 phan so thu hai
     * @return ket qua nhan duoc gan vao phan so thu nhat
     */
    public Solution multiply(Solution s2) {
        int x = this.numerator;
        int y = this.denominator;
        this.numerator = x * s2.numerator;
        this.denominator = y * s2.denominator;
        reduce();
        return this;
    }

    /**
     * chia 2 phan so.
     *
     * @param s2 phan so thu hai
     * @return ket qua cong duoc gan vao phan so thu nhat
     */
    public Solution divide(Solution s2) {
        int x = this.numerator;
        int y = this.denominator;
        this.numerator = x * s2.denominator;
        this.denominator = y * s2.numerator;
        reduce();
        return this;
    }


    /**
     * so sanh 2 phan so.
     *
     * @param obj kieu du lieu
     * @return neu kieu du lieu la Solution thi tiep tuc so sanh, khong thi tra ve false
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        } else {
            Solution other = (Solution) obj;
            other.reduce();
            if (this.numerator == other.numerator && this.denominator == other.denominator) {
                return true;
            } else return false;
        }

    }

    public static void main(String[] args) {
        Solution s1 = new Solution(5, 10);
        s1.reduce();
        System.out.println(s1.numerator + "/" + s1.denominator);
        Solution s2 = new Solution(2, 3);
        s1.add(s2);
        System.out.println(s1.numerator + "/" + s1.denominator);
    }

}
