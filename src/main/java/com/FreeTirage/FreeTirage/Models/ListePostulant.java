package com.FreeTirage.FreeTirage.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_liste_postulant")
    private Long id_liste_postulant;
    private String libelle;
    private Date date;

   }
