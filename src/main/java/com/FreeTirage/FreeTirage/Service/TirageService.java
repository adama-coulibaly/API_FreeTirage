package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.Tirage;

import java.util.List;

public interface TirageService {

    Tirage add(Tirage tirage);

    Tirage update(Long id_tirage, Tirage tirage);

    String delete(Long id_tirage);

    List<Tirage> lire();
}
