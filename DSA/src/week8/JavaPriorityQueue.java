package week8;

import java.util.*;

// https://www.hackerrank.com/challenges/java-priority-queue/problem
class Priorities {
    List<Student> getStudents(List<String> events) {
        Queue<Student> s = new PriorityQueue<>(new StudentComparator());
        List<Student> result = new ArrayList<Student>();
        for (String e : events) {
            if (e.equals("SERVED")) {
                if (!result.isEmpty()) {
                    result.remove(0);
                }
            } else {
                String[] parts = e.split(" ");

                String name = parts[1];
                double gpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                result.add(new Student(name, gpa, id));
                result.sort(new StudentComparator());
            }
        }

        return result;
    }
}

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(String name, double gpa, int id) {
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        int cgpa = Double.compare(y.getGpa(), x.getGpa());
        if (cgpa != 0) {
            return cgpa;
        }

        int cname = x.getName().compareTo(y.getName());
        if (cname != 0) {
            return cname;
        }

        return Integer.compare(x.getId(), y.getId());
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
