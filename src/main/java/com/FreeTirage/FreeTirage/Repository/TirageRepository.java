package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface TirageRepository extends JpaRepository<Tirage, Long> {

    @Query(value = "SELECT postulants.id_postulant,postulants.nom_postulant," +
            "postulants.prenom_postulant " +
            "FROM postulants,postulants_tirages " +
            "WHERE postulants.id_postulant = postulants_tirages.postulants_id_postulant;",
            nativeQuery = true)

    Iterable<Object[]> personnesTirer();


}
