package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListePostulantRepository extends JpaRepository<ListePostulant, Long> {

@Query(value = "SELECT COUNT(*) FROM `liste_postulant` WHERE liste_postulant.nbre_tirage != 0;",nativeQuery = true)
public int listeTirer();



    ListePostulant findByLibelle(String libelle);

    List<ListePostulant> findByIdliste(Long idliste);


}
