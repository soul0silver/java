package lab02.Lab02_1;

public class Student {
    private int id;
    private String name;
    private boolean gender;

    public Student(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }
    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println("| ID |        Name         | Male |");
        System.out.printf("| %2d | %19s | %2b |\n",this.id,this.name,this.gender);
    }

}
