package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Repository.PostulantRepository;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Api(value = "hello", description = "Les requetes possible sur ma table pays")
    @RestController
    @RequestMapping("/postulant")
    @AllArgsConstructor

    public class PostulantsControllers {

        /* Permet de creer une entrée pour*/
        private final PostulantService postulantService;

// Insertion des données depuis un fichiers CSV
    @Autowired
    PostulantRepository service;
    @PostMapping("/upload/{listepostulant_id_liste_postulant}")
    public String uploadData(@RequestParam("file") MultipartFile file) throws IOException {

        List<Postulants> listePostulants = new ArrayList<>();

        InputStream inputStream = file.getInputStream();

        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new  CsvParser(setting);
        List<Record> passerAllRecord = parser.parseAllRecords(inputStream);

        passerAllRecord.forEach(record -> {
            Postulants account = new Postulants();
            account.setNom_postulant(record.getString("nom_postulant"));
            account.setPrenom_postulant(record.getString("prenom_postulant"));
            account.setEmail_postulant(record.getString("email_postulant"));
            account.setNumero_postulant(record.getString("numero_postulant"));
         //   account.setListepostulant(record.getInt(int i));
            listePostulants.add(account);
        });
        service.saveAll(listePostulants);



        return "Fichier telecharger avec succes";
    }


    /*
        @PostMapping("/add")
        @ApiOperation(value = "Permet de creer une entrée pour un pays")
        public Postulants add(@RequestBody Postulants postulants) {
            return postulantService.add(postulants);
        }

        Permet d'afficher la liste de toute les  postulants
    */
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
