package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface TirageRepository extends JpaRepository<Tirage, Long> {


    // LA REQUETE PERMETTANT DE TROUVER LES POSTULANTS TRIERS
    @Query(value = "SELECT postulants.id_postulant,postulants.nom_postulant," +
            "postulants.prenom_postulant " +
            "FROM postulants,postulants_tirages,tirage " +
            "WHERE postulants.id_postulant = postulants_tirages.postulants_id_postulant AND libelle = :libelle",
            nativeQuery = true)

    Iterable<Object[]> personnesTirer();



}
