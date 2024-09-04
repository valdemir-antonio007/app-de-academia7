package dio.me.App.controller;

import dio.me.App.model.Matricula;
import dio.me.App.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll(){
        return ResponseEntity.ok().body(matriculaService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(matriculaService.getOne(id));
    }
    @PostMapping("/{alunoId}")
    public ResponseEntity<Matricula> create(@PathVariable Long alunoId){
        return ResponseEntity.ok().body(matriculaService.create(alunoId));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Matricula> delete(@PathVariable Long id){
        matriculaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
