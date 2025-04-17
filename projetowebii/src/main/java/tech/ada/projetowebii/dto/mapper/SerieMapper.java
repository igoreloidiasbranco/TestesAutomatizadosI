package tech.ada.projetowebii.dto.mapper;

import tech.ada.projetowebii.dto.SerieDTO;
import tech.ada.projetowebii.model.Serie;

public class SerieMapper {

    public static SerieDTO toSerieDTO(Serie serie) {
        SerieDTO serieDTO = new SerieDTO(
                serie.getTitulo(), serie.getGenero(),
                serie.getTemporadas(), serie.getAnoLancamento()
        );

        return serieDTO;
    }
}


