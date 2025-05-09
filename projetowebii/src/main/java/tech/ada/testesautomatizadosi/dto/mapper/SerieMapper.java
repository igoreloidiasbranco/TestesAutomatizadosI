package tech.ada.testesautomatizadosi.dto.mapper;

import tech.ada.testesautomatizadosi.dto.SerieDTO;
import tech.ada.testesautomatizadosi.model.Serie;

public class SerieMapper {

    public static SerieDTO toSerieDTO(Serie serie) {
        SerieDTO serieDTO = new SerieDTO(
                serie.getTitulo(), serie.getGenero(),
                serie.getTemporadas(), serie.getAnoLancamento()
        );

        return serieDTO;
    }
}


