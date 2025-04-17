package tech.ada.projetowebii.service;

import org.springframework.stereotype.Service;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.repository.SeriesRepository;

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
