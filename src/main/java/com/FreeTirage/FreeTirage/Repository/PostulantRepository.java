package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulants, Long> {

    @Query(value = "SELECT postulants.nom_postulant," +
            "postulants.prenom_postulant," +
            "postulants.email_postulant," +
            "postulants.numero_postulant,liste_postulant.libelle " +
            "FROM postulants,liste_postulant WHERE" +
            " postulants.listepostulant_id_liste_postulant = liste_postulant.id_liste_postulant;" +
            "\n",nativeQuery = true)

    Iterable<Object[]> listerPostulants();

}
