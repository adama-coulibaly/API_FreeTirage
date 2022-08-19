package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Repository.TirageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TirageServiceImpl implements TirageService {

    private final TirageRepository tirageRepository;

    @Override
    public Tirage add(Tirage tirage) {
        return tirageRepository.save(tirage);
    }

    @Override
    public List<Tirage> lire() {
        return tirageRepository.findAll();
    }

    @Override
    public Tirage update(Long id_tirage, Tirage tirage) {
        return tirageRepository.findById(id_tirage)
                .map(tirage1 -> {
                    tirage1.setDate_tirage(tirage.getDate_tirage());
                    tirage1.setLibelle_tirage(tirage.getLibelle_tirage());
                    tirage1.setNbre_postulant_tirer(tirage.getNbre_postulant_tirer());

                    return tirageRepository.save(tirage1);
                }).orElseThrow(() -> new RuntimeException("Postulant non trouvé"));
    }

    @Override
    public String delete(Long id_tirage) {
       tirageRepository.deleteById(id_tirage);
        return "Tirage supprimé";
    }

}
