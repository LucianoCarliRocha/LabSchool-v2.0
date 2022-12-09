package techdevinhouse.labschool.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techdevinhouse.labschool.Exception.RegistroExistenteException;
import techdevinhouse.labschool.Exception.RegistroNaoEncontradoException;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Model.Professor;
import techdevinhouse.labschool.Repository.PedagogoRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PedagogoService {
    private PedagogoRepository repoPedagogo;

    public Pedagogo salvarPedagogo(Pedagogo pedagogo) {
        Optional<Pedagogo> pedagogoOpt = repoPedagogo.findByCpf(pedagogo.getCpf());
        if (pedagogoOpt.isPresent())
            throw new RegistroExistenteException("Pedagogo", pedagogo.getCodigo());
        pedagogo = repoPedagogo.save(pedagogo);
        return pedagogo;
    }

    public List<Pedagogo> consultarPedagogo() {
        return repoPedagogo.findAll();
    }

    public Pedagogo consultarPedagogo(Integer codigo) {
        Optional<Pedagogo> pedagogoOpt = repoPedagogo.findById(codigo);
        if (pedagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Pedagogo",codigo);
        Pedagogo pedagogo = pedagogoOpt.get();
        return pedagogo;
    }

}
