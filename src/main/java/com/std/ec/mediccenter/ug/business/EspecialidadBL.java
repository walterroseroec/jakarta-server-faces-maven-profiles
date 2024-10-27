package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Especialidad;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;


@Stateless
@LocalBean
public class EspecialidadBL {

    @EJB
    private IRepository repository;

    public Especialidad grabar(Especialidad e) {
        return repository.especialidad().insertar(e);
    }

    public Especialidad actualizar(Especialidad e) {
        return repository.especialidad().actualizar(e);
    }

    public List<Especialidad> listar() {
        return repository.especialidad().listar();
    }

    public Especialidad buscarId(int id) {
        return repository.especialidad().buscarId(id);
    }

}
