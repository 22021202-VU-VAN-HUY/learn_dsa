import java.util.PriorityQueue;
import java.util.Scanner;

public class test {

    public static void show(PriorityQueue s){
        System.out.print("dãy ");
        int h=s.size();
        PriorityQueue<Integer> ctHeap = new PriorityQueue<>(s);
        for (int i=0;i<h;i++){
            System.out.print(ctHeap.poll()+" ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<Integer> ctHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            ctHeap.add(height);
        }

        for (int i = 0; i < m; i++) {

            int type = scanner.nextInt();
            if (type == 1) {
                int c = scanner.nextInt();

                System.out.println("1. Them "+c);
                ctHeap.add(c);

                show(ctHeap);
            } else if (type == 2) {
                System.out.print("2. Xoa ");
                int h = ctHeap.size();
                PriorityQueue<Integer> temp = new PriorityQueue<>();
                if (h==0) System.out.println(0);    ///////
                else {
                    if (h % 2 == 0) {
                        for (int j = 0; j < h / 2 - 1; j++) {
                            temp.add(ctHeap.poll());
                        }
                        System.out.println(ctHeap.poll());
                    } else {
                        for (int j = 0; j <= h / 2 - 1; j++) {
                            temp.add(ctHeap.poll());
                        }
                        System.out.println(ctHeap.poll());
                    }
                    ctHeap.addAll(temp);
                    show(ctHeap);
                }
            } else if (type == 3) {
                System.out.print("3. vi tri trung vi ");
                int h = ctHeap.size();
                PriorityQueue<Integer> copyHeap = new PriorityQueue<>(ctHeap);
                if (h==0) System.out.println(0);
                else if (h % 2 == 0) {
                    for (int j = 0; j < h / 2 - 1; j++) {
                        copyHeap.poll();
                    }
                    System.out.println(copyHeap.peek());
                } else {
                    for (int j = 0; j <= h / 2 - 1; j++) {
                        copyHeap.poll();
                    }
                    System.out.println(copyHeap.peek());
                }
                show(ctHeap);
            }
        }
    }
}