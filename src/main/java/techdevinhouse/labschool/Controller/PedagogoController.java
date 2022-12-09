package techdevinhouse.labschool.Controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techdevinhouse.labschool.Dto.PedagogoResponse;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Service.PedagogoService;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor

public class PedagogoController {

    private ModelMapper mapper;
    private PedagogoService service;

    @PostMapping
    public ResponseEntity<PedagogoResponse> criarPedagogo(@RequestBody @Valid PedagogoResponse response) {
        Pedagogo pedagogo = mapper.map(response, Pedagogo.class);
        pedagogo = service.salvarPedagogo(pedagogo);
        PedagogoResponse responsePedagogo = mapper.map(pedagogo, PedagogoResponse.class);
        return ResponseEntity.created(URI.create(responsePedagogo.getCodigo().toString())).body(responsePedagogo);
    }

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> listarPedagogo() {
        List<Pedagogo> pedagogos = service.consultarPedagogo();
        List<PedagogoResponse> respPedagogo = new ArrayList<>();
        for(Pedagogo pedagogo: pedagogos) {
            PedagogoResponse pedagogoResp = mapper.map(pedagogo, PedagogoResponse.class);
            respPedagogo.add(pedagogoResp);
        }
        return ResponseEntity.ok(respPedagogo);
    }

}
