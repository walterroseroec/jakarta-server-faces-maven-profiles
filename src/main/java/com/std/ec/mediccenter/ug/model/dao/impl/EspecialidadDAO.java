package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IEspecialidad;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Especialidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class EspecialidadDAO extends Dao<Especialidad> implements IEspecialidad {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadDAO() {
        super(Especialidad.class);
    }

    @Override
    public List<Especialidad> listar() {
        Query lQuery = em.createQuery("select e from Especialidad e");
        List<Especialidad> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
