package tech.ada.testesautomatizadosi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tech.ada.testesautomatizadosi.model.Serie;
import tech.ada.testesautomatizadosi.repository.SeriesRepository;

class CriarSerieServiceTest {

    CriarSerieService service;
    SeriesRepository repository;

    @BeforeEach
    public void setUp() {

        repository = Mockito.mock(SeriesRepository.class);
        service = new CriarSerieService(repository);
    }

    @Test
    @DisplayName("Dado uma série válida, deve criar uma série com sucesso")
    public void testeCriarSerie() {
        Serie serieValida = umaSerie();
        Serie serieSalvaNoBancoDeDados = umaSerie();


        Mockito.when(repository.save(serieValida)).thenReturn(serieSalvaNoBancoDeDados);
        Serie serieCriada = service.criarSerie(serieValida);

        Assertions.assertNotNull(serieCriada);
        Assertions.assertEquals(serieCriada, serieSalvaNoBancoDeDados);
        Assertions.assertNotNull(serieCriada.getTitulo());
        Mockito.verify(repository, Mockito.times(1)).save(serieValida);

    }

    private Serie umaSerie() {
        Serie serie = new Serie();
        serie.setTitulo("Título da Série");
        serie.setGenero("Gênero da Série");
        serie.setTemporadas(1);
        serie.setAnoLancamento(2025);
        return serie;
    }
}