package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.EspecialidadBL;

import java.io.Serializable;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Especialidad;
import com.std.ec.mediccenter.ug.util.AppConfigProperty;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("especialidadController")
@ViewScoped
public class EspecialidadController implements Serializable {

    private Especialidad especialidad;
    private Especialidad seleccionar;
    private List<Especialidad> listar = null;

    @EJB
    private EspecialidadBL local;

    public EspecialidadController() {
        especialidad = new Especialidad();
    }

    public List<Especialidad> getListar() {
        listar = local.listar();
        return listar;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (especialidad.getIdEspecialidad()== null) {
            local.grabar(especialidad);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            local.actualizar(especialidad);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar() != null) {
            setEspecialidad(getSeleccionar());
        }
    }

    public void nuevo() {
        especialidad = new Especialidad();
    }

}
