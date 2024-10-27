package com.std.ec.mediccenter.ug.model.dao;

import jakarta.ejb.Local;

/**
 * @param <T>
 * @author WALTER ROSERO
 */
@Local
public interface IDao<T> {

    T insertar(T entity);

    T actualizar(T entity);

    void eliminar(T entity);

    T buscarId(Object entityID);
}
