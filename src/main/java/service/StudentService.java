package service;

import exceptions.AgeException;
import exceptions.GrupaException;
import model.Student;
import repository.DBStudentRepository;
import repository.IRepository;
import repository.StudentRepository;
import validators.StudentValidator;

import java.util.List;

public class StudentService {
    private final DBStudentRepository repository;

    public StudentService(DBStudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(String nume, int varsta, String grupa, List<Integer> note) throws RuntimeException, AgeException, GrupaException{
        Student s = new Student(nume, varsta, grupa, note);
        try{
            StudentValidator.validate(s);
            repository.save(s);
        } catch(RuntimeException e){
            throw new RuntimeException(e);
        } catch (GrupaException e) {
            throw new GrupaException(e.getMessage());
        } catch (AgeException e) {
            throw new AgeException(e.getMessage());
        }
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