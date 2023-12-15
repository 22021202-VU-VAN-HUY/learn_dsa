import java.util.*;

public class temp {
    public static void balance(PriorityQueue<Long> left,PriorityQueue<Long> right){
        if ((left.size() - right.size()) > 1) {
            right.offer(left.poll());
        }
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        PriorityQueue<Long> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> right = new PriorityQueue<>();
        ArrayList<Long> a = new ArrayList<>(n);
        while (n != 0) {
            long tmp = sc.nextInt();
            a.add(tmp);
            n--;
        }
        Collections.sort(a);
        int mid = a.size() / 2 + (a.size() % 2 == 0 ? -1 : 0);
        for (int i = 0; i < a.size(); i++) {
            if (i <= mid) {
                left.offer(a.get(i));
            } else {
                right.offer(a.get(i));
            }
        }
        while (q != 0) {
            int type = sc.nextInt();
            if (type == 1) {
                long temp = sc.nextInt();
                if (right.isEmpty()){
                    left.offer(temp);
                }
                else if (temp > right.peek()) {
                    left.offer(right.poll());
                    right.offer(temp);
                } else {
                    left.offer(temp);
                }
                balance(left,right);
            } else if (type == 2) {
                if (!left.isEmpty()) {
                    left.poll();
                }
                balance(left,right);

            } else if (type == 3) {
                if (!left.isEmpty()) {
                    System.out.println(left.peek());
                } else System.out.println(0);
            }
            q--;
        }
    }
}


/*
    5 12
5 8 1 8 3
3
1 1
3
1 4
3
2
3
1 3
3
1 7
3
1 6

5
3
4
3
3
3
 */