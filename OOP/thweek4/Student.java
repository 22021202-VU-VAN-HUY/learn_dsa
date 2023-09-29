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
        this.name = "Nguyen Van An";
        this.id = "17020001";
        this.group = "K62CC";
        this.email = "17020001@vnu.edu.vn";
    }

    /**
     *
     * @param name
     * @param id
     * @param email
     */

    Student(String name, String id, String email) {
        // TODO:
        this.name = name;
        this.id = id;
        this.email = email;

    }


    /**
     *
     * @param s
     */
    Student(Student s) {
        // TODO:
        this.name = s.name;
        this.id = s.id;
        this.email = s.email;

    }

    String getInfo() {
        // TODO:
        return this.name + " - " + this.id + " - " + this.group + " - " + this.email;
        //return null; // xoa dong nay sau khi cai dat
    }
}