package tech.ada.testesautomatizadosi.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.ada.testesautomatizadosi.dto.CriarSerieRequestDTO;
import tech.ada.testesautomatizadosi.model.Serie;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SerieControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testeCriarSerie() {

        CriarSerieRequestDTO serieDTO = new CriarSerieRequestDTO();
        serieDTO.setTitulo("Titulo");
        serieDTO.setGenero("Gênero");
        serieDTO.setTemporadas(1);
        serieDTO.setAnoLancamento(2025);

        ResponseEntity<Serie> response =
                restTemplate.exchange(
                        "/series", HttpMethod.POST,
                        new HttpEntity<>(serieDTO), Serie.class
                );

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(serieDTO.getTitulo(), response.getBody().getTitulo());
        Assertions.assertNotNull(response.getBody().getId());
    }

}