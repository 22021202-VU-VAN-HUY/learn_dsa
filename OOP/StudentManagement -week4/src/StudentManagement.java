public class StudentManagement {
    // TODO: khai bao thuoc tinh students la array chua cac doi tuong thuoc lop Student (max. 100)
    private Student[] students = new Student[100];
    private int studentCount = 0;
    /**
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
     * add a student to the array students
     * @param newStudent the new student to add
     */
    public void addStudent(Student newStudent){
        // TODO:
        students[studentCount] = newStudent;
        studentCount ++;
    }

    /**
     *
     * @return string group
     */
    public String studentsByGroup() {
        //return null;
        String[] groups = new String[studentCount];
        int groupCount=0;
        for (int i=0;i<studentCount;i++){
            boolean end_group = false;
            for (int j=0;j<groupCount;j++){
                if (students[i].getGroup().equals(students[j].getGroup())){
                    end_group = true;
                    break;
                }
            }
            if (!end_group) {
                groups[groupCount++]= students[i].getGroup();
            }
        }
        
        String result = "";
        for (int i=0;i<groupCount;i++){
            result += groups[i] +"\n";
            for (int j=0;j<studentCount;j++){
                if (students[j].getGroup().equals(groups[i])){
                    result += students[j].getInfo() + "\n";
                }
            }
        }
        return result;
    }

    /**
     *
     * @param id string after remove
     */
    public void removeStudent(String id) {
        // TODO:
        int index = -1;
        for (int i=0;i<studentCount;i++){
            if (students[i].getId().equals(id)){
                index = i;
                break;
            }
        }
        if (index!=-1){
            for (int i=index;i<studentCount-1;i++){
                students[i] =students[i+1];
            }
            studentCount--;
        } else return;
    }

    public static void main(String[] args) {
        // TODO:
        Student s1= new Student("Nguyen Van An","17020001","K62CC");
        //Student s1= new Student("Nguyen Van An","17020001","K62CC","17020001@vnu.edu.vn");
        System.out.println(s1.getInfo());
        return;
    }
}