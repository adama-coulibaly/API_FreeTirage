package com.FreeTirage.FreeTirage.Models;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@NoArgsConstructor
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

    @ManyToMany
    private List<Tirage> tirages;


    public Postulants(Long id_postulant, String nom_postulant, String prenom_postulant, String numero_postulant, String email_postulant, ListePostulant listepostulant, List<Tirage> tirages) {
        super();
        this.id_postulant = id_postulant;
        this.nom_postulant = nom_postulant;
        this.prenom_postulant = prenom_postulant;
        this.numero_postulant = numero_postulant;
        this.email_postulant = email_postulant;
        this.listepostulant = listepostulant;
        this.tirages = tirages;
    }
}