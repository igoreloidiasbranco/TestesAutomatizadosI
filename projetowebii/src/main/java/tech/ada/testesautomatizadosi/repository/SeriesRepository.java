package tech.ada.testesautomatizadosi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.testesautomatizadosi.model.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {
}