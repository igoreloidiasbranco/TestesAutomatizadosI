package tech.ada.projetowebii.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.projetowebii.dto.CriarSerieRequestDTO;
import tech.ada.projetowebii.dto.AtualizarSerieDTO;
import tech.ada.projetowebii.dto.SerieDTO;
import tech.ada.projetowebii.dto.mapper.CriarSerieRequestMapper;
import tech.ada.projetowebii.model.Serie;
import tech.ada.projetowebii.service.AtualizarSerieService;
import tech.ada.projetowebii.service.BuscarSeriesService;
import tech.ada.projetowebii.service.CriarSerieService;
import tech.ada.projetowebii.service.ExcluirSerieService;

import java.util.List;

@RestController
@RequestMapping("/series")

public class SerieController {

    private final CriarSerieService criarSerieService;
    private final AtualizarSerieService atualizarSerieService;
    private final BuscarSeriesService buscarSeriesService;
    private final ExcluirSerieService excluirSerieService;

    public SerieController(CriarSerieService criarSerieService, AtualizarSerieService atualizarSerieService, BuscarSeriesService buscarSeriesService, ExcluirSerieService excluirSerieService) {
        this.criarSerieService = criarSerieService;
        this.atualizarSerieService = atualizarSerieService;
        this.buscarSeriesService = buscarSeriesService;
        this.excluirSerieService = excluirSerieService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        excluirSerieService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<SerieDTO> buscarTodasAsSeries() {
        return buscarSeriesService.buscarTodasAsSeries();
    }

    @GetMapping("/{id}")
    public Serie buscarSeriePorId(@PathVariable (value = "id") Long id) {
        return buscarSeriesService.buscarSeriePorId(id);
    }

}
