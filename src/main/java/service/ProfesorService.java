package service;

import exceptions.DuplicateElement;
import model.Profesor;
import repository.ProfesorRepository;

import java.util.List;

public class ProfesorService {
    private ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public void addProfesor(String nume, String materie, List<String> clase) throws DuplicateElement {
        try{
            repository.save(new Profesor(nume, materie, clase));
        } catch (DuplicateElement e){
            throw new DuplicateElement(e.getMessage());
        }
    }

    public void printProfesori() {
        repository.findAll().forEach(System.out::println);
    }
}