package service;

import model.Student;
import repository.DBStudentRepository;
import repository.IRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final DBStudentRepository repository;

    public StudentService(DBStudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(String nume, int varsta, String grupa, List<Integer> note) {
        Student s = new Student(nume, varsta, grupa, note);
        repository.save(s);
    }

    public void printStudents() {
        repository.findAll().forEach(System.out::println);
    }

    public void delete(String nume, int varsta, String grupa, List<Integer> note) {
        repository.delete(new Student(nume, varsta, grupa, note));
    }

    public List<Integer> getNotePerStudent(String nume, int varsta, String grupa, List<Integer> note){
        return repository.getNotePerStudent(new Student(nume, varsta, grupa, note));
    }
}