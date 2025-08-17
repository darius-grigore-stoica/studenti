package com.company;

import model.Student;
import repository.DBStudentRepository;
import repository.ProfesorRepository;
import repository.StudentRepository;
import service.ProfesorService;
import service.StudentService;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileReader("bd.config"));
            DBStudentRepository studentRepo = new DBStudentRepository(props);
            ProfesorRepository profesorRepo = new ProfesorRepository();

            StudentService studentService = new StudentService(studentRepo);

            Student s = new Student("Andrei", 19, "324", null);
            s.setNote(studentService.getNotePerStudent("Andrei", 19, "324", null));

            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}