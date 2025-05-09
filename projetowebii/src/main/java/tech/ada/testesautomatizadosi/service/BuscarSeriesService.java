package tech.ada.testesautomatizadosi.service;

import org.springframework.stereotype.Service;
import tech.ada.testesautomatizadosi.dto.SerieDTO;
import tech.ada.testesautomatizadosi.dto.mapper.SerieMapper;
import tech.ada.testesautomatizadosi.exception.SerieNaoEncontradaException;
import tech.ada.testesautomatizadosi.model.Serie;
import tech.ada.testesautomatizadosi.repository.SeriesRepository;
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
        return serieOptional.orElseThrow(() -> new SerieNaoEncontradaException("Série com ID " + id +
                " não encontrada"));
    }
}
