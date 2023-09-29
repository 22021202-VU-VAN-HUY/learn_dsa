import org.junit.Assert;
import org.junit.Test;

public class Week4Test {
    @Test
    public void testMax2Int1(){
        int actualResult = Week4.max2Int(4,5);
        int expectedResult = 5;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int2(){
        int actualResult = Week4.max2Int(-100,0);
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int3(){
        int actualResult = Week4.max2Int(10,10);
        int expectedResult = 10;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int4(){
        int actualResult = Week4.max2Int(0,3);
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int5(){
        int actualResult = Week4.max2Int(10000,4);
        int expectedResult = 10000;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray1(){
        int[] array = {12, 13, -24, 0};
        int test_array = Week4.minArray(array);
        Assert.assertEquals(-24, test_array);
    }

    @Test
    public void testMinArray2(){
        int[] array = {5, 4, 3, 2, 1};
        int test_array = Week4.minArray(array);
        Assert.assertEquals(1, test_array);
    }

    @Test
    public void testMinArray3(){
        int[] array = {0, 0, 0, 0};
        int test_array = Week4.minArray(array);
        Assert.assertEquals(0, test_array);
    }

    @Test
    public void testMinArray4(){
        int[] array = {-1000, 0, 1, 1000};
        int test_array = Week4.minArray(array);
        Assert.assertEquals(-1000, test_array);
    }

    @Test
    public void testMinArray5(){
        int[] array = {11111, 10101, 12012, 13000};
        int test_array = Week4.minArray(array);
        Assert.assertEquals(10101, test_array);
    }

    @Test
    public void testCalculateBMI1(){
        double weight = 50;
        double height = 1.5;
        String check = Week4.calculateBMI(weight,height);
        //22.(2) - "Bình thường"
        String answer = "Bình thường";
        Assert.assertEquals(answer, check);
    }

    @Test
    public void testCalculateBMI2(){
        double weight = 50;
        double height = 1.3;
        String check = Week4.calculateBMI(weight,height);
        //29.58 - "Béo phì"
        String answer = "Béo phì";
        Assert.assertEquals(answer, check);
    }

    @Test
    public void testCalculateBMI3(){
        double weight = 58.8;
        double height = 1.6;
        String check = Week4.calculateBMI(weight,height);
        // 23 - "Thừa cân"
        String answer = "Thừa cân";
        Assert.assertEquals(answer, check);
    }

    @Test
    public void testCalculateBMI4(){
        double weight = 48;
        double height = 1.65;
        String check = Week4.calculateBMI(weight,height);
        //17.63 - "Thiếu cân"
        String answer = "Thiếu cân";
        Assert.assertEquals(answer, check);
    }

    @Test
    public void testCalculateBMI5(){
        double weight = 50;
        double height = 1.7;
        String check = Week4.calculateBMI(weight,height);
        //17.3 - "Thiếu cân"
        String answer = "Thiếu cân";
        Assert.assertEquals(answer, check);
    }
}