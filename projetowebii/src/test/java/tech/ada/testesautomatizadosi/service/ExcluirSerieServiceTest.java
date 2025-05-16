package tech.ada.testesautomatizadosi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tech.ada.testesautomatizadosi.repository.SeriesRepository;


class ExcluirSerieServiceTest {

    ExcluirSerieService excluirSerieService;
    SeriesRepository repository;



    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(SeriesRepository.class);

        excluirSerieService = new ExcluirSerieService(repository);
    }



    @Test
    void deveLancarUmaExcecaoAoNaoEncontrarUmaSerie() {

        Long id = 1L;

        Mockito.when(repository.findById(id))
                .thenThrow(new RuntimeException("Série com ID " + id + " não encontrada."));


        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> excluirSerieService.excluir(id));


        Assertions.assertNotNull(exception);
        Assertions.assertNotNull(exception.getMessage());
    }
}