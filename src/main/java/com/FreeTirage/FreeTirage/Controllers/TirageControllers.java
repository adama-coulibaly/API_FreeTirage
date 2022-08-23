package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Service.ListePostulantService;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import com.FreeTirage.FreeTirage.Service.TirageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "hello")
@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageControllers {

    /* Permet de creer une entrée pour*/
    private final TirageService tirageService;
    private final PostulantService postulantService;
    private  final ListePostulantService listePostulantService;

    /*Permet de supprimer un tirage donnée*/
    @DeleteMapping("/delete/{id_tirage}")
    @ApiOperation(value = "Permet de supprimer un postulant donnée")
    public String supprimer(@PathVariable Long id_tirage) {
        return tirageService.delete(id_tirage);
    }

    //***********************************************Les nouvelles modifications



    //La methode permettant de faire un tri sur les tirages
    @PostMapping("/faireTirage/{libelle}/{nombre}")
    public Object create(@PathVariable("libelle") String libelle, @PathVariable("nombre") int nbre)
    {
        ListePostulant listePostulant=listePostulantService.RetrouverParLibelle(libelle);
        if(listePostulant!=null){
            Tirage tirage=new Tirage();
            tirage.setNbre_postulant_tirer(nbre);
            tirage.setLibelle_tirage(libelle);
            tirage.setDate_tirage(new Date());
            return tirageService.creerTirage(tirage,postulantService.listePost(listePostulant),nbre);

        }else {
            return "Cette liste n'existe pas!!";
        }

    }

    // AFFICHER LA LISTE
    @GetMapping("/afficherListe/{libelle}")
    public Iterable<Object[]> personnesTirer() {
        return tirageService.personnesTirer();
    }

}
