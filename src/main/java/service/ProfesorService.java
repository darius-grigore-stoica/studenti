package service;

import model.Profesor;
import repository.ProfesorRepository;

import java.util.List;

public class ProfesorService {
    private ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public void addProfesor(String nume, String materie, List<String> clase) {
        repository.save(new Profesor(nume, materie, clase));
    }

    public void printProfesori() {
        repository.findAll().forEach(System.out::println);
    }
}