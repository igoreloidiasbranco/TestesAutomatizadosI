package tech.ada.projetowebii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.projetowebii.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}