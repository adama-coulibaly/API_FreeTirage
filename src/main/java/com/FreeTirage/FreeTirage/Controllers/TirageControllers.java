package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Repository.TirageRepository;
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
@CrossOrigin(origins = "http://localhost:4200")
public class TirageControllers {

    /* Permet de creer une entrée pour*/
    private final TirageService tirageService;
    private final PostulantService postulantService;
    private  final ListePostulantService listePostulantService;
    private final TirageRepository tirageRepository;
    /*Permet de supprimer un tirage donnée*/
    @DeleteMapping("/delete/{id_tirage}")
    @ApiOperation(value = "Permet de supprimer un postulant donnée")
    public String supprimer(@PathVariable Long id_tirage) {
        return tirageService.delete(id_tirage);
    }

    //***********************************************Les nouvelles modifications



    //La methode permettant de faire un tri sur les tirages
    @PostMapping("/faireTirage/{libelle}/{nombre}")
    public Object create(@RequestBody Tirage tirage, @PathVariable("libelle") String libelle, @PathVariable("nombre") int nbre)
    {
        ListePostulant listePostulant=listePostulantService.RetrouverParLibelle(libelle);

        listePostulantService.update(listePostulant.getIdliste(),listePostulant);

        listePostulantService.modifier(listePostulant.getIdliste());





        if(listePostulant!=null){
           // ListePostulant liste = new ListePostulant();

            ListePostulant liste = listePostulantService.RetrouverParLibelle(libelle);


            tirage.setNbre_postulant_tirer(nbre);



            tirage.setDate_tirage(new Date());
            tirage.setListePostulantList(liste);



            return tirageService.creerTirage(tirage,postulantService.listePost(listePostulant),nbre);

        }else {
            return "Cette liste n'existe pas!!";
        }

    }


    @GetMapping("/listerTiragrePersonnes/{libelle}")
    public Iterable<Object[]> personnesTirer(@PathVariable("libelle") String libelle) {
        return tirageService.personnesTirer(libelle);
    }

    //Le nombre total des tirages
    @GetMapping("/nombreTirage")
    public String nombreT() {
        return tirageService.nombreT();
    }
    @GetMapping("/nombreTirageParListe/{libelle}")
    public String nombreTliste(@PathVariable("libelle") String libelle) {
        return tirageService.nombreTliste();
    }
// Afficher les listes
    @GetMapping("/listeParTirage/{id_liste}")
    public List<Tirage> listeT(@PathVariable("id_liste") Long id_liste)
    {
        return tirageService.trouverTirageParListe(id_liste);
    }

// Afficher les personnes par leur tirages
    @GetMapping("/personnes/{tirages_id_tirage}")
    public List<Object> personneT(@PathVariable("tirages_id_tirage") Long id_liste)
    {
        return tirageService.lesPersonnesParTirage(id_liste);
    }
// Recupperer un tirage
@GetMapping("/recuperer/{id_tirage}")
Tirage tirageRecuper(@PathVariable("id_tirage") Long id_liste)
{
    return tirageRepository.recupererUnTirage(id_liste);
}


}
