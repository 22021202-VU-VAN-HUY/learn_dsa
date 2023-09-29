public class Student {

    // TODO: khai bao cac thuoc tinh cho Student
    private String name;
    private String id;
    private String group;
    private String email;
    // TODO: khai bao cac phuong thuc getter, setter cho Student

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Constructor 1
     */
    Student() {
        // TODO:
        this.name = "Student";
        this.id = "000";
        this.group = "K62CB";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * @param name name of the student
     * @param id student id
     * @param email student 's email address
     */

    Student(String name, String id, String email) {
        // TODO:
        this.name = name;
        this.id = id;
        this.email = email;
        this.group = "K62CB";
    }


    /**
     * @param s another student object to copy information from
     */
    Student(Student s) {
        // TODO:
        this.name = s.getName();
        this.id = s.getId();
        this.email = s.getEmail();
        this.group = s.getGroup();
    }

    String getInfo() {
        // TODO:
        return this.name + " - " + this.id + " - " + this.group + " - " + this.email;
        //return null; // xoa dong nay sau khi cai dat
    }
}