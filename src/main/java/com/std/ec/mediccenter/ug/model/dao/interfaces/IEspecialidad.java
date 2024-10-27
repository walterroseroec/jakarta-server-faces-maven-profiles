package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.Especialidad;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IEspecialidad extends IDao<Especialidad> {

    List<Especialidad> listar();

}
