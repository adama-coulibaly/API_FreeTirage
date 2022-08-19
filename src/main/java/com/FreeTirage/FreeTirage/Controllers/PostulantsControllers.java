package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les requetes possible sur ma table pays")
    @RestController
    @RequestMapping("/postulant")
    @AllArgsConstructor

    public class PostulantsControllers {

        /* Permet de creer une entrée pour*/
        private final PostulantService postulantService;
        @PostMapping("/add")
        @ApiOperation(value = "Permet de creer une entrée pour un pays")
        public Postulants add(@RequestBody Postulants postulants) {
            return postulantService.add(postulants);
        }

        /*Permet d'afficher la liste de toute les  postulants*/
        @GetMapping("/read")
        @ApiOperation(value = "Permet d'afficher la liste de toute les  pays")
        public List<Postulants> lire() {
            return postulantService.lire();
        }

        /*Permet de modifier un postulants donné*/
        @PutMapping("/update/{id_postulant}")
        @ApiOperation(value = "Permet de modifier un pays donné")
        public Postulants update(@PathVariable Long id_postulant, @RequestBody Postulants postulants) {
            return postulantService.update(id_postulant, postulants);
        }

        /*Permet de supprimer un postulant donnée*/
        @DeleteMapping("/delete/{id_postulant}")
        @ApiOperation(value = "Permet de supprimer un pays donnée")
        public String supprimer(@PathVariable Long id_postulant) {
            return postulantService.delete(id_postulant);
        }

    }
