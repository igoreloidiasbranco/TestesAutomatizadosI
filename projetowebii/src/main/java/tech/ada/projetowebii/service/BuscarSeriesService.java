package tech.ada.projetowebii.service;

import org.springframework.stereotype.Service;
import tech.ada.projetowebii.dto.SerieDTO;
import tech.ada.projetowebii.dto.mapper.SerieMapper;
import tech.ada.projetowebii.exception.SerieNaoEncontradaException;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.repository.SeriesRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuscarSeriesService {

    private final SeriesRepository seriesRepository;


    public BuscarSeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public List<SerieDTO> buscarTodasAsSeries() {
        return seriesRepository.findAll().stream()
                .map(serie -> SerieMapper.toSerieDTO(serie)).collect(Collectors.toList());
    }

    public Serie buscarSeriePorId(Long id) {
        Optional<Serie> serieOptional = seriesRepository.findById(id);
        return serieOptional.orElseThrow(() -> new SerieNaoEncontradaException("Série com ID " +
                " não encontrada"));
    }
}
