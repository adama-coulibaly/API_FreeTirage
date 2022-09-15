package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TirageRepository extends JpaRepository<Tirage, Long> {


    // LA REQUETE PERMETTANT DE TROUVER LES POSTULANTS TRIERS
    @Query(value = "SELECT liste_postulant.libelle, liste_postulant.date," +
            "postulants.nom_postulant, postulants.prenom_postulant," +
            " postulants.email_postulant, postulants.numero_postulant," +
            "tirage.date_tirage, tirage.libelle_tirage from liste_postulant," +
            "postulants , tirage,postulants_tirages WHERE postulants.id_postulant=" +
            " postulants_tirages.postulants_id_postulant AND tirage.id_tirage=" +
            " postulants_tirages.tirages_id_tirage AND liste_postulant.id_liste_postulant=" +
            " postulants.listepostulant_id_liste_postulant AND liste_postulant.libelle = :libelle",nativeQuery = true)

    public Iterable<Object[]> personnesTirer(@Param("libelle") String libelle);

    @Query(value = "SELECT COUNT(id_tirage) FROM tirage",nativeQuery = true)
    public String nombreTirage();
    @Query(value = "SELECT COUNT(*),idliste FROM tirage,\n" +
            "liste_postulant WHERE tirage.id_liste = liste_postulant.idliste GROUP BY idliste;",nativeQuery = true)
    public  String nombreTirageParListe();

    @Query(value = "SELECT * FROM tirage WHERE tirage.id_liste = :id_liste",nativeQuery = true)
    List<Tirage> trouverTirageParListe(@Param("id_liste") Long id_liste);

    @Query(value = "SELECT postulants.nom_postulant,postulants.prenom_postulant,postulants.email_postulant," +
            "postulants.numero_postulant,postulants.listepostulant_idliste FROM `postulants_tirages`,`postulants`" +
            " WHERE  postulants.id_postulant = postulants_tirages.postulants_id_postulant  " +
            "AND postulants_tirages.tirages_id_tirage = :tirages_id_tirage",nativeQuery = true)
    List<Object> personnesParTirage(@Param("tirages_id_tirage") Long tirages_id_tirage);

@Query(value = "SELECT * FROM `tirage` WHERE tirage.id_tirage = :id_tirage",nativeQuery = true)
    Tirage recupererUnTirage(@Param("id_tirage") Long id_tirage);


}
