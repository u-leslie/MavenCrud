package com.HibernateTest;

import com.Models.Student;
import com.Models.Teacher;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.controller.StudentDao;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Create a StudentDao instance
        StudentDao studentDao = new StudentDao();

        // Creating a new student
        Student st1 = new Student();
        st1.setStudentId(4);
        st1.setFirstName("Anne");
        st1.setLastName("Leslie");
        st1.setEmailAddress("anne@gmail.com");
        studentDao.createStudent(st1);
        System.out.println("Created student with ID: " + st1.getStudentId());

        // Reading one student
        Student studentToRead = studentDao.getStudentById(4);
        if (studentToRead != null) {
            System.out.println("Id : " + studentToRead.getStudentId());
            System.out.println("First Name : " + studentToRead.getFirstName());
            System.out.println("Last Name : " + studentToRead.getLastName());
            System.out.println("Email : " + studentToRead.getEmailAddress());
        } else {
            System.out.println("Student with ID 1 not found");
        }

        // Updating an existing student
        Student studentToUpdate = studentDao.getStudentById(4);
        if (studentToUpdate != null) {
            studentToUpdate.setEmailAddress("updatedemail@example.com");
            studentDao.updateStudent(studentToUpdate);
            System.out.println("Updated student with ID: " + studentToUpdate.getStudentId());
        } else {
            System.out.println("Student with ID 1 not found");
        }


        // Reading all students
        List<Student> students = studentDao.getAllStudents();
        System.out.println("All Students:");
        for (Student s : students) {
            System.out.println("Id : " + s.getStudentId());
            System.out.println("Name : " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Email : " + s.getEmailAddress());
        }

        // Deleting a student
        Student studentToDelete = studentDao.getStudentById(4);
        if (studentToDelete != null) {
            studentDao.deleteStudent(studentToDelete);
            System.out.println("Deleted student with ID: " + studentToDelete.getStudentId());
        } else {
            System.out.println("Student with ID 1 not found");
        }

    }
}


