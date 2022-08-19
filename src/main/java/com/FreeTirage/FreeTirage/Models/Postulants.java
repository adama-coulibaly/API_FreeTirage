package com.FreeTirage.FreeTirage.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulant")
    private Long id_postulant;
    private String nom_postulant;
    private String prenom_postulant;
    private String numero_postulant;
    private String email_postulant;

    //
    @ManyToOne
    private ListePostulant listepostulant;


}
