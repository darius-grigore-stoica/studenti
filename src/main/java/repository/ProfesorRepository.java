package repository;

import model.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorRepository implements IRepository<Profesor> {

    private List<Profesor> profesors;

    public ProfesorRepository() {
        this.profesors = new ArrayList<>();
    }
    @Override
    public void save(Profesor entity) {
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
