package repository;

import exceptions.DuplicateElement;
import model.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfesorRepository implements IRepository<Profesor> {

    private List<Profesor> profesors;

    public ProfesorRepository() {
        this.profesors = new ArrayList<>();
    }
    @Override
    public void save(Profesor entity) throws DuplicateElement {
        for(Profesor p : profesors){
            if(Objects.equals(p.getNume(), entity.getNume())){
                throw new DuplicateElement("Profesorul cu numele " + entity.getNume() + " este inregistrat deja");
            }
        }
        profesors.add(entity);
    }

    @Override
    public void update(Profesor oldEntity, Profesor newEntity) {
        profesors.remove(oldEntity);
        profesors.add(newEntity);
    }

    @Override
    public void delete(Profesor entity) {
        profesors.remove(entity);
    }

    @Override
    public List<Profesor> findAll() {
        return this.profesors;
    }
}
