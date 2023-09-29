public class Week4 {

    public static int max2Int(int a, int b) {
        // Tim gia tri lon nhat cua hai so nguyen
        if (a>b) return a;
        else return b;
    }

    public static int minArray (int[] array) {
        // Tim gia tri nho nhat cua 1 mang so nguyen
        int n = array.length;
        int minn = array[0];
        for (int i=1;i<n;i++) {
            if (minn>array[i]) minn=array[i];
        }
        return minn;
    }

    public static String calculateBMI(double weight, double height){
        // Tinh BMI
        double BMI = Math.round(10* weight / (height*height))/10.0;
        if (BMI < 18.5) return "Thiếu cân";
        else if (BMI >= 18.5 && BMI <= 22.9) {
            return "Bình thường";
        }
        else if (BMI >=23 && BMI <= 24.9) {
            return "Thừa cân";
        }
        else return "Béo phì";
    }

}
