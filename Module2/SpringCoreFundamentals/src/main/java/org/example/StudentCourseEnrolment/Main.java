package org.example.StudentCourseEnrolment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        try {
            StudentService studentService =
                    context.getBean(StudentService.class);

            studentService.displayStudentProfile();
        } finally {
            context.close();
        }
    }
}