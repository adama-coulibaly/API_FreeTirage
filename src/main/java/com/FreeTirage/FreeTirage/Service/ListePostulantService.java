package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;

import java.util.List;
import java.util.Optional;

public interface ListePostulantService {

    ListePostulant add(ListePostulant listePostulant);

    List<ListePostulant> lire();/*C'est la méthode permettant d'afficher une liste des pays créer*/


    ListePostulant update(Long id_liste_postulant, ListePostulant listePostulant);

    ListePostulant modifier(Long id_liste_postulant);

    String delete(Long id_liste_postulant);


    int listeTirer();


    Optional<ListePostulant> lesPostulants(Long id_postulant);

    ListePostulant RetrouverParLibelle(String libelle);
    ListePostulant uneListe(Long id_liste_postulant);

    List<ListePostulant> trouverParListe(Long id);




}
