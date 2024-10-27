package com.std.ec.mediccenter.ug.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;

    @Size(max = 120)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 120)
    private String descripcion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

}