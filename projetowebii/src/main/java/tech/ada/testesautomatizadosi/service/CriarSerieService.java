package tech.ada.testesautomatizadosi.service;

import org.springframework.stereotype.Service;
import tech.ada.testesautomatizadosi.model.Serie;
import tech.ada.testesautomatizadosi.repository.SeriesRepository;

@Service
public class CriarSerieService {

    private final SeriesRepository repository;

    public CriarSerieService(SeriesRepository repository) {
        this.repository = repository;
    }

    public Serie criarSerie(Serie serie) {
        return repository.save(serie);
    }
}
