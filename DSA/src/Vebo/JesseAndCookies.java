package Vebo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem
public class JesseAndCookies {


    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PQueue p = new PQueue();
        for (int i = 0; i < A.size(); i++) {
            p.push(A.get(i));
        }
        int count = 0;
        while (p.size() >= 2) {
            int number1 = p.poll();
            if (number1 >= k) {
                return count;
            }

            int number2 = p.poll();
            p.push(number1 + 2 * number2);
            count++;
        }

        if (!p.isEmpty() && p.peek() >= k) {
            return count;
        }

        return -1;
    }

    private static class PQueue {
        private int size;
        private int[] queue;

        public PQueue() {
            queue = new int[10000001];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public int peek() {
            return queue[1];
        }

        public void push(int value) {
            if (isEmpty()) {
                size++;
                queue[1] = value;
                return;
            } else {
                queue[++size] = value;
                int idmax = size;
                int mid = idmax / 2;
                while (mid >= 1 && queue[mid] > queue[idmax]) {
                    int tmp = queue[mid];
                    queue[mid] = queue[idmax];
                    queue[idmax] = tmp;
                    idmax = mid;
                    mid = mid / 2;
                }
            }
        }

        public int poll() {
            if (isEmpty()) {
                return -1;
            }
            int min = queue[1];
            queue[1] = queue[size--];
            int mid = 1;
            while (true) {
                int left = 2 * mid;
                int right = 2 * mid + 1;
                int minid = mid;
                if (left <= size && queue[left] < queue[minid]) {
                    minid = left;
                }
                if (right <= size && queue[right] < queue[minid]) {
                    minid = right;
                }
                if (minid == mid) {
                    break;
                }
                int temp = queue[mid];
                queue[mid] = queue[minid];
                queue[minid] = temp;

                mid = minid;
            }
            return min;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        System.out.println(cookies(k, a));
    }
}
