package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IRepository<Student>{

    private List<Student> students;

    public StudentRepository(){
        this.students = new ArrayList<>();
    }

    @Override
    public void save(Student entity) {
        students.add(entity);
    }

    @Override
    public void update(Student oldEntity, Student newEntity) {

    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }
}
