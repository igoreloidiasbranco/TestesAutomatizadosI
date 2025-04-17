package tech.ada.projetowebii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.projetowebii.model.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {
}