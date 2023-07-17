package com.app.servicioauto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="Autos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="Marca", length = 30, nullable = false)
    String marca;

    @Column(name="Modelo", length = 30, nullable = false)
    String modelo;

    @Column(name = "Id_Usuario", nullable = false)
    int idUsuario;

}
