package repository;

import java.util.List;

public interface IRepository<T> {
    void save(T entity);
    void update(T oldEntity, T newEntity);
    void delete(T entity);
    List<T> findAll();
}
