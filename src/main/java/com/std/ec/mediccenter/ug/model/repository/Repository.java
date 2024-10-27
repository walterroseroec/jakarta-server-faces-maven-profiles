package com.std.ec.mediccenter.ug.model.repository;

import com.std.ec.mediccenter.ug.model.dao.interfaces.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.io.Serializable;

/**
 * @author Walter Rosero
 */
@Stateless
public class Repository implements IRepository, Serializable {


    @EJB
    private IEspecialidad especialidad;

    @Override
    public IEspecialidad especialidad() {
        return this.especialidad;
    }

}
