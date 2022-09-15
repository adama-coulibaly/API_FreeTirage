package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TirageService {

    Tirage add(Tirage tirage);
    String nombreT();
String nombreTliste();

    Tirage update(Long id_tirage, Tirage tirage);

    String delete(Long id_tirage);

    List<Tirage> lire();

    List<Postulants> creerTirage(Tirage tirage, List<Postulants> listATrier, int nbre);


    Iterable<Object[]> personnesTirer(String libelle);

    List<Tirage> trouverTirageParListe(Long idliste);

    List<Object> lesPersonnesParTirage(Long tirages_id_tirage);


}
