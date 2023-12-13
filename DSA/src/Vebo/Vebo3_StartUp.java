package Vebo;


import java.io.*;
import java.util.*;
class Startup{
    private int id;
    private int value;
    public Startup(int id, int value){
        this.id=id;
        this.value=value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
public class Vebo3_StartUp {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Startup> result = new PriorityQueue<>(Comparator.comparingInt(Startup::getValue));
        int n = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                Startup temp = new Startup(i+1,sc.nextInt());
                result.add(temp);
            } else if (k == 2) {
                int v = sc.nextInt();
                while (result.size()>=v){
                    result.poll();
                }
            }
        }

        int end = sc.nextInt();
        if (result.size()>=sc.nextInt()){
            long sum =0;
            List<Integer> res = new ArrayList<>();

            while (!result.isEmpty()){
                Startup s = result.poll();
                sum+=s.getValue();
                res.add(s.getId());
            }
            Collections.sort(res);
            System.out.println(sum);
            for (Integer temp:res){
                System.out.print(temp+" ");
            }
        }
        else System.out.println(-1);
    }
}
