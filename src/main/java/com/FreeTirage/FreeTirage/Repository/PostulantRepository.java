package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulants, Long> {

}
