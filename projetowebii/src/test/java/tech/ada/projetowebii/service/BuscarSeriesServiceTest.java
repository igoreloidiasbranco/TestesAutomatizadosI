package tech.ada.projetowebii.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tech.ada.projetowebii.dto.SerieDTO;
import tech.ada.projetowebii.exception.SerieNaoEncontradaException;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.repository.SeriesRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

class BuscarSeriesServiceTest {

    BuscarSeriesService service;
    SeriesRepository repository;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(SeriesRepository.class);
        service = new BuscarSeriesService(repository);
    }

    @Test
    @DisplayName("Deve buscar todas as séries com sucesso")
    void testeBuscarTodasAsSeries() {

        Serie serie1 = new Serie(1L, "Título1", "Gênero1", 1, 2021);
        Serie serie2 = new Serie(2L, "Título2", "Gênero2", 2, 2022);
        Mockito.when(repository.findAll()).thenReturn(List.of(serie1, serie2));

        List<SerieDTO> seriesRetornadas = service.buscarTodasAsSeries();

        Assertions.assertNotNull(seriesRetornadas);
        Assertions.assertEquals(2, seriesRetornadas.size());
        Assertions.assertEquals("Título1", seriesRetornadas.get(0).getTitulo());
        Assertions.assertEquals("Título2", seriesRetornadas.get(1).getTitulo());
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia")
    void testeListaDeSeriesVazia() {

        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        List<SerieDTO> seriesRetornados = service.buscarTodasAsSeries();


        Assertions.assertNotNull(seriesRetornados);
        Assertions.assertTrue(seriesRetornados.isEmpty());
    }


    @Test
    @DisplayName("Deve retornar uma série buscando por Id com sucesso")
    void buscarSeriePorId() {
        Serie serie1 = new Serie(1L, "Título1", "Gênero1", 1, 2021);
        Long id = 1L;
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(serie1));

        Serie serieRetornada = service.buscarSeriePorId(id);

        Assertions.assertNotNull(serieRetornada);
        Assertions.assertEquals(id, serieRetornada.getId());
        Assertions.assertEquals("Gênero1", serieRetornada.getGenero());

    }


    @Test
    @DisplayName("Deve lançar uma exceção quando uma série não for encontrada")
    void testeExcecaoQuandoSerieNaoEncontrada() {

        Long id = 1L;
        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());


        SerieNaoEncontradaException exception = Assertions.assertThrows(
                SerieNaoEncontradaException.class, () -> service.buscarSeriePorId(id));


        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Série com ID " + id + " não encontrada", exception.getMessage());

    }
}