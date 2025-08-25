package repository;

import exceptions.DuplicateElement;

import java.util.List;

public interface IRepository<T> {
    void save(T entity) throws DuplicateElement;
    void update(T oldEntity, T newEntity);
    void delete(T entity);
    List<T> findAll();
}
