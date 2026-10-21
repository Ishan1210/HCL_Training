package org.example.StudentCourseEnrolment;

public class Student {
    private int studentId;
    private String studentName;
    private Course course;

    public Student(int studentId, String studentName, Course course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);

        course.displayCourseDetails();
    }
}
