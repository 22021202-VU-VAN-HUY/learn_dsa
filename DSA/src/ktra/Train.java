package ktra;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Train {
    public static int vitri(Queue<Integer> s, int x){
        int result=0;
        for (int i=0;i<s.size();i++){
            s.poll();
            if (x==i){
                result =  s.poll();
                break;
            }
        }
        return result;
    }

    public static Queue xoacuoi(Queue<Integer> s){
        Queue temp = s;
        int k=s.size()-1;
        for (int i=0;i<k;i++){
            temp.add(s.poll());
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Queue<Integer> s = new LinkedList<>();
        Queue<Integer> s1 = new LinkedList<>();
        Queue<Integer> s2= new LinkedList<>();

        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            s.add(i+1);
        }
        int m=sc.nextInt();
        for (int i=0;i<m;i++){
            int k=sc.nextInt();
            if (k==1){
                //int dau=s[0];
                int dau = s.poll();
                int x= sc.nextInt();
                if (x==1){
                    s1.add(dau);
                }
                else if (x==2){
                    s2.add(dau);
                }
            }
            else if(k==2){
                int temp = sc.nextInt();
                if (temp==1){
                    s1.poll();
                }
                else if (temp==2){
                    s2=xoacuoi(s2);
                }
            }
            else if (k==3){
                int x = sc.nextInt();
                if (x==1){
                    System.out.println(s1.size());
                }
                else if (x==2){
                    System.out.println(s2.size());
                }

            }
            else if (k==4){
                System.out.println(s.size());
            }
            else if (k==5){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a==1){
                    System.out.println(vitri(s1,b-1));
                }
                else if (a==2){
                    System.out.println(vitri(s2,b-1));
                }
            }
        }
    }

}
