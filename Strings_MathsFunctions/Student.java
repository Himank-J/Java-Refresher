package Strings_MathsFunctions;

class Student {
    String name;
    int age;

    Student (String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student name is ").append(this.name);
        sb.append("\nStudent Age is ").append(age);
        return sb.toString();
    }

    public static void main(String[] args) {
        Student s = new Student("Himank", 25);
        System.out.println(s);
    }
}
