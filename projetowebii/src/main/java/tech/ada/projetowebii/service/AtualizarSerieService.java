package tech.ada.projetowebii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.projetowebii.dto.AtualizarSerieDTO;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.repository.SeriesRepository;

@Service
public class AtualizarSerieService {

    private final SeriesRepository repository;

    @Autowired
    public AtualizarSerieService(SeriesRepository repository) {
        this.repository = repository;
    }

    public Serie atualizar(Long id, AtualizarSerieDTO dto) {
        return repository.findById(id).map(serie -> {
            if (dto.getTitulo() != null) {
                serie.setTitulo(dto.getTitulo());
            }
            if (dto.getGenero() != null) {
                serie.setGenero(dto.getGenero());
            }
            if (dto.getTemporadas() != null) {
                serie.setTemporadas(dto.getTemporadas());
            }
            if (dto.getAnoLancamento() != null) {
                serie.setAnoLancamento(dto.getAnoLancamento());
            }
            return repository.save(serie);
        }).orElseThrow(() -> new RuntimeException("Série com ID " + id + " não encontrada."));
    }
}
