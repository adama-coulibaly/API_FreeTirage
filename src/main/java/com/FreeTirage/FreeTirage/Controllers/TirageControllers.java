package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import com.FreeTirage.FreeTirage.Service.TirageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les requetes possible sur ma table pays")
@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageControllers {

    /* Permet de creer une entrée pour*/
    private final TirageService tirageService;
    @PostMapping("/add")
    @ApiOperation(value = "Permet de creer une entrée pour un pays")
    public Tirage add(@RequestBody Tirage tirage) {
        return tirageService.add(tirage);
    }

    /*Permet d'afficher la liste de toute les  postulants*/
    @GetMapping("/read")
    @ApiOperation(value = "Permet d'afficher la liste de toute les  pays")
    public List<Tirage> lire() {
        return tirageService.lire();
    }

    /*Permet de modifier un postulants donné*/
    @PutMapping("/update/{id_tirage}")
    @ApiOperation(value = "Permet de modifier un pays donné")
    public Tirage update(@PathVariable Long id_tirage, @RequestBody Tirage tirage) {
        return tirageService.update(id_tirage, tirage);
    }

    /*Permet de supprimer un postulant donnée*/
    @DeleteMapping("/delete/{id_tirage}")
    @ApiOperation(value = "Permet de supprimer un pays donnée")
    public String supprimer(@PathVariable Long id_tirage) {
        return tirageService.delete(id_tirage);
    }

}
