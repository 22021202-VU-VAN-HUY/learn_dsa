public class StudentManagement {
    // TODO: khai bao thuoc tinh students la array chua cac doi tuong thuoc lop Student (max. 100)
    private Student[] students = new Student[100];
    private int studentCount = 0;

    /**
     * so sanh lop cua 2 hoc sinh.
     *
     * @param s1 student 1
     * @param s2 student 2
     * @return bool
     */
    public static boolean sameGroup(Student s1, Student s2) {
        // TODO:
        return s1.getGroup().equals(s2.getGroup());
        //return false; // xoa dong nay sau khi cai dat
    }

    /**
     * add a student to the array students.
     *
     * @param newStudent the new student to add
     */
    public void addStudent(Student newStudent) {
        // TODO:
        students[studentCount] = newStudent;
        this.studentCount++;
    }

    /**
     * nhom cac hoc sinh.
     *
     * @return danh sach cac hoc sinh sau khi nhom lop
     */
    public String studentsByGroup() {
        String[] groups = new String[studentCount];
        int groupCount = 0;
        for (int i = 0; i < studentCount; i++) {
            boolean endgroup = false;
            for (int j = 0; j < groupCount; j++) {
                if (students[i].getGroup().equals(students[j].getGroup())) {
                    endgroup = true;
                    break;
                }
            }
            if (!endgroup) {
                groups[groupCount] = students[i].getGroup();
                groupCount++;
            }
            System.out.println(i);
        }

        String result = "";
        for (int i = 0; i < groupCount; i++) {
            result += groups[i] + "\n";
            for (int j = 0; j < studentCount; j++) {
                if (students[j].getGroup().equals(groups[i])) {
                    result += students[j].getInfo() + "\n";
                }
            }
        }
        return result;
    }

    /**
     * remove Student .
     *
     * @param id string after remove
     */
    public void removeStudent(String id) {
        // TODO:
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }
            studentCount--;
        } else {
            return;
        }

    }


    /*
    public static void main(String[] args) {
        // TODO:
        Student s1= new Student("Nguyen Van An","17020001","17020001@vnu.edu.vn");
        s1.setGroup("K67CC");

        Student s2= new Student("Nguyen Van C","17020003","17020003@vnu.edu.vn");
        s2.setGroup("K67CB");

        Student s3= new Student("Nguyen Van B","17020002","17020002@vnu.edu.vn");
        s3.setGroup("K67CC");

        Student s4= new Student("Nguyen Van D","17020004","17020004@vnu.edu.vn");
        s4.setGroup("K67CB");

        StudentManagement s = new StudentManagement();
        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);
        s.addStudent(s4);
        //System.out.println(s.students[0].getInfo());
        //System.out.println(s.students[0].getGroup());
        System.out.println(s.studentsByGroup());
    }

     */


}