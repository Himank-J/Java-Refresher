package Collection_Generics;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("A", 98.5);
        Student student2 = new Student("B", 94);
        Student student3 = new Student("C", 99);

        Comparator<Student> gradeCompare = (st1, st2) -> Double.compare(st2.getGrade(), st1.getGrade());
        PriorityQueue<Student> pq = new PriorityQueue<>(gradeCompare);
        Collections.addAll(pq, student1, student2, student3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }
}
