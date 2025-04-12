package tech.ada.projetowebii.dto.mapper;

import tech.ada.projetowebii.dto.CriarSerieRequestDTO;
import tech.ada.projetowebii.model.Serie;

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
