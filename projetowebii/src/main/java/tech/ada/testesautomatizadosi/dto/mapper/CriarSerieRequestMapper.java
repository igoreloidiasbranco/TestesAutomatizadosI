package tech.ada.testesautomatizadosi.dto.mapper;

import tech.ada.testesautomatizadosi.dto.CriarSerieRequestDTO;
import tech.ada.testesautomatizadosi.model.Serie;

public class CriarSerieRequestMapper {

    public static Serie toEntity(CriarSerieRequestDTO dto) {
        Serie serie = new Serie();
        serie.setTitulo(dto.getTitulo());
        serie.setGenero(dto.getGenero());
        serie.setTemporadas(dto.getTemporadas());
        serie.setAnoLancamento(dto.getAnoLancamento());
        return serie;
    }
}
