package techdevinhouse.labschool.Controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import techdevinhouse.labschool.Dto.AlunoRequest;
import techdevinhouse.labschool.Dto.AlunoResponse;
import techdevinhouse.labschool.Dto.SituacaoRequestAluno;
import techdevinhouse.labschool.Model.Aluno;
import techdevinhouse.labschool.Service.AlunoService;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;
import techdevinhouse.labschool.ValidadorDeEnun.ValorEnum;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
@Validated
public class AlunoController {

    private ModelMapper mapper;
    private AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest request) {
        Aluno aluno = mapper.map(request, Aluno.class);
        aluno = service.salvar(aluno);
        AlunoResponse responseAluno = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(responseAluno.getCodigo().toString())).body(responseAluno);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listar(@RequestParam (value = "situacao", required = false) @ValorEnum(enumClass = SituacaoAluno.class, message = "{campo.invalido}" ) String situacaoAluno) {
        List<Aluno> alunos;
        if (situacaoAluno == null){
            alunos = service.consultarAluno();
        } else {
            alunos = service.consultarAluno(situacaoAluno);
        }
        List<AlunoResponse> respAluno = new ArrayList<>();
        for(Aluno aluno: alunos) {
            AlunoResponse AlunoResp = mapper.map(aluno, AlunoResponse.class);
            respAluno.add(AlunoResp);
        }
        return ResponseEntity.ok(respAluno);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> listarPeloCodigo(@PathVariable("codigo") Integer codigo) {
        Aluno aluno = service.consultarAluno(codigo);
        AlunoResponse respAluno = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(respAluno);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizarSitAluno(@PathVariable("codigo")Integer codigo, @RequestBody @Valid SituacaoRequestAluno request) {
        SituacaoAluno situacaoAluno = SituacaoAluno.valueOf(request.getSituacaoAluno());
        Aluno aluno = service.atualizarSituacaoAluno(codigo, situacaoAluno);
        AlunoResponse respAluno = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(respAluno);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity excluir(@PathVariable("codigo") int codigo) {
        service.excluirAluno(codigo);
        return ResponseEntity.noContent().build();
    }


}
