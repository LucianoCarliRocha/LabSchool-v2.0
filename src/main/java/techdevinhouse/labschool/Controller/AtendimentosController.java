package techdevinhouse.labschool.Controller;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techdevinhouse.labschool.Dto.AlunoResponse;
import techdevinhouse.labschool.Dto.AtendimentosRequest;
import techdevinhouse.labschool.Dto.AtendimentosResponse;
import techdevinhouse.labschool.Dto.PedagogoResponse;
import techdevinhouse.labschool.Model.Aluno;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Service.AlunoService;
import techdevinhouse.labschool.Service.AtendimentoService;
import techdevinhouse.labschool.Service.PedagogoService;
import javax.validation.Valid;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor

public class AtendimentosController {

    private ModelMapper mapper;
    private AtendimentoService service;
    private AlunoService alunoService;
    private PedagogoService pedagogoService;

    @PutMapping
    public ResponseEntity<AtendimentosResponse> atualizar (@RequestBody @Valid AtendimentosRequest request ){
       service.atendimentos(request.getCodigoAluno(), request.getCodigoPedagogo());
       Aluno alunoAtendimento = alunoService.consultarAluno(request.getCodigoAluno());
       Pedagogo pedagogoAtendimento = pedagogoService.consultarPedagogo(request.getCodigoPedagogo());
       AlunoResponse responseAluno = mapper.map(alunoAtendimento, AlunoResponse.class);
       PedagogoResponse responsePedagogo= mapper.map(pedagogoAtendimento, PedagogoResponse.class);
       AtendimentosResponse atendimentosResponse = new AtendimentosResponse(responseAluno, responsePedagogo);
       return ResponseEntity.ok(atendimentosResponse);
    }

}
