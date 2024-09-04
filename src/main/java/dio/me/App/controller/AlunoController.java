package dio.me.App.controller;

import dio.me.App.model.Aluno;
import dio.me.App.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok().body(alunoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.getOne(id));
    }
    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        return ResponseEntity.ok().body(alunoService.create(aluno));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno){
        return ResponseEntity.ok().body(alunoService.update(id, aluno));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
