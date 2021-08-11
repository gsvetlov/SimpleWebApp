package ru.svetlov.webapp.service.base;

import java.util.List;

public interface BaseServiceCrud<T> {
    T getById(Long id);

    List<T> getByIds(List<Long> ids);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
