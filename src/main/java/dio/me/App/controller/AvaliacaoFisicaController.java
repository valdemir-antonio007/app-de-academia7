package dio.me.App.controller;

import dio.me.App.model.AvaliacaoFisica;
import dio.me.App.service.AvaliacaoFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll(){
        return ResponseEntity.ok().body(avaliacaoFisicaService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(avaliacaoFisicaService.getOne(id));
    }
    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@RequestParam(name = "alunoId")Long alunoId,
                                                  @RequestBody AvaliacaoFisica avaliacao){
        return ResponseEntity.ok().body(avaliacaoFisicaService.create(alunoId, avaliacao));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisica avaliacao){
        return ResponseEntity.ok().body(avaliacaoFisicaService.update(id, avaliacao));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        avaliacaoFisicaService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AvaliacaoFisica>> getAllAvaliacoesPorAluno(@PathVariable Long alunoId){
        return ResponseEntity.ok().body(avaliacaoFisicaService.getAllAvaliacoesPorAluno(alunoId));
    }
}
