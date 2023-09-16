package week3.Sum;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sherlock {

    public static String result (List<Integer> a){
        if (a == null ) {
            return "NO";
        }
        if(a.size() == 1){
            return "YES";
        }
        int sum =0; // sum

        for (int i=0;i<a.size();i++){
            sum+=a.get(i);
        }

        int sumL = 0;
        for(int i=0; i<a.size(); i++){
            if(i==0){
                sumL +=0;
            }else{
                sumL+=a.get(i-1);
            }
            int sumR = sum - sumL-a.get(i);
            if(sumL == sumR){
                return "YES";
            }
        }
        return "NO";
    }


    public static void main(String[] args) {
        In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\DSA\\src\\week3\\Sherlock_test2.txt");
        int space = in.readInt();
        //System.out.println(space);
        for (int i=0;i < space ; i ++){
            List<Integer> a = new ArrayList<Integer>();
            int n = in.readInt();
            for (int j = 0; j <n;j++){
                int k =in.readInt();
                a.add(k);
            }
            //String s = result(a);
            System.out.println(result(a));
        }
    }
}
