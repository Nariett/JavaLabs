package TestTwo;

public class Student {
    private int age;
    private String address;
    public Student() {
        this.age = 0;
        this.address = "";
    }

    public Student(int age, String address) {
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
