package tech.ada.projetowebii.service;

import org.springframework.stereotype.Service;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.repository.SerieRepository;

import java.time.LocalDateTime;

@Service
public class CriarSerieService {

    private final SerieRepository repository;

    public CriarSerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public Serie criarSerie(Serie serie) {
        serie.setDataCriacao(LocalDateTime.now());
        serie.setDataAtualizacao(LocalDateTime.now());
        return repository.save(serie);
    }
}
