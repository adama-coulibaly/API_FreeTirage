package com.FreeTirage.FreeTirage.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tirage")
public class Tirage {

    @Id
    private Long id_tirage;
    private String libelle_tirage;
    private Date date_tirage;
    private int nbre_da_tirer;

}
