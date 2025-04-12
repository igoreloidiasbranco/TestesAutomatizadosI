package tech.ada.projetowebii.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.projetowebii.dto.CriarSerieRequestDTO;
import tech.ada.projetowebii.dto.mapper.CriarSerieRequestMapper;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.service.CriarSerieService;

@RestController
@RequestMapping("/api/series")

public class SerieController {

    private final CriarSerieService criarSerieService;

    public SerieController(CriarSerieService criarSerieService) {
        this.criarSerieService = criarSerieService;
    }

    @PostMapping
    public ResponseEntity<Serie> criarSerie(@RequestBody @Valid CriarSerieRequestDTO dto) {
        Serie novaSerie = criarSerieService.criarSerie(CriarSerieRequestMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSerie);
    }
}
