package tech.ada.projetowebii.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.projetowebii.dto.CriarSerieRequestDTO;
import tech.ada.projetowebii.dto.AtualizarSerieDTO;
import tech.ada.projetowebii.dto.mapper.CriarSerieRequestMapper;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.service.AtualizarSerieService;
import tech.ada.projetowebii.service.CriarSerieService;

@RestController
@RequestMapping("/series")

public class SerieController {

    private final CriarSerieService criarSerieService;
    private final AtualizarSerieService atualizarSerieService;

    public SerieController(CriarSerieService criarSerieService, AtualizarSerieService atualizarSerieService) {
        this.criarSerieService = criarSerieService;
        this.atualizarSerieService = atualizarSerieService;
    }

    @PostMapping
    public ResponseEntity<Serie> criarSerie(@RequestBody @Valid CriarSerieRequestDTO dto) {
        Serie novaSerie = criarSerieService.criarSerie(CriarSerieRequestMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarSerieDTO dto) {
        Serie serieAtualizada = atualizarSerieService.atualizar(id, dto);
        return ResponseEntity.ok(serieAtualizada);
    }
}
