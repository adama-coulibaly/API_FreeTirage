package com.FreeTirage.FreeTirage.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Postulants")
public class Postulants {

    @Id
    private Long id_postulant;
    private String nom_postulant;
    private String prenom_postulant;
    private String numero_postulant;
    private String email_postulant;

}
