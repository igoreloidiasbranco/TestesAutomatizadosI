package tech.ada.projetowebii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.projetowebii.repository.SeriesRepository;

@Service
public class ExcluirSerieService {

    private final SeriesRepository repository;

    @Autowired
    public ExcluirSerieService(SeriesRepository repository) {
        this.repository = repository;
    }

    public void excluir(Long id) {
        repository.findById(id).map(serie -> {
            repository.delete(serie);
            return serie;
        }).orElseThrow(() -> new RuntimeException("Série com ID " + id + " não encontrada."));
    }
}
