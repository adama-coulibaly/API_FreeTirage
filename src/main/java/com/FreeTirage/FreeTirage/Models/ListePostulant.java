package com.FreeTirage.FreeTirage.Models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idliste")
    private Long idliste;
    private String libelle;
    private Date date;
    private int nbreTirage;



    public ListePostulant(Long id_liste_postulant, String libelle, Date date) {
        super();
        this.idliste = id_liste_postulant;
        this.libelle = libelle;
        this.date = date;
    }
}
