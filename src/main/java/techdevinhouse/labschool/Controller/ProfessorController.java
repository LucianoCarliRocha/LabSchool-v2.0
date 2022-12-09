package techdevinhouse.labschool.Controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techdevinhouse.labschool.Dto.ProfessorRequest;
import techdevinhouse.labschool.Dto.ProfessorResponse;
import techdevinhouse.labschool.Model.Professor;
import techdevinhouse.labschool.Service.ProfessorService;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {

    private ModelMapper mapper;
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponse> criarProfessor(@RequestBody @Valid ProfessorRequest request) {
        Professor professor = mapper.map(request, Professor.class);
        professor = service.salvarProfessor(professor);
        ProfessorResponse responseProfessor = mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.created(URI.create(responseProfessor.getCodigo().toString())).body(responseProfessor);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listarProfessor() {
        List<Professor> professores = service.consultarProfessor();
        List<ProfessorResponse> respProfessor = new ArrayList<>();
        for(Professor professor: professores) {
            ProfessorResponse professorResp = mapper.map(professor, ProfessorResponse.class);
            respProfessor.add(professorResp);
        }
        return ResponseEntity.ok(respProfessor);
    }
}
