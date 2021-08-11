package ru.svetlov.webapp.repo.base;

import java.util.List;

public interface BaseDao<T> {
    T create(T entity);

    T getById(Long id);

    List<T> getByIds(List<Long> ids);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
