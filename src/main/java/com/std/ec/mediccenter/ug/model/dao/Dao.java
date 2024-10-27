
package com.std.ec.mediccenter.ug.model.dao;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class Dao<T> implements IDao<T> {

    private final Class<T> entityClass;

    public Dao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "MedicCenterEc_PU")
    protected EntityManager em;

    protected abstract EntityManager getEntityManager();
    
    @Override
    public T insertar(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T actualizar(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T buscarId(Object entityID) {
       return getEntityManager().find(entityClass, entityID);
    }

}
