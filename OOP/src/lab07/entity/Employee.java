package lab07.entity;

public class Employee {
    private String name;
    private int age;
    private int eid;

    public Employee() {
    }

    public Employee(String name, int age, int eid) {
        this.name = name;
        this.age = age;
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eid=" + eid +
                '}';
    }
}
