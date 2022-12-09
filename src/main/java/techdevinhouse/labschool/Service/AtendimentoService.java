package techdevinhouse.labschool.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techdevinhouse.labschool.Exception.RegistroNaoEncontradoException;
import techdevinhouse.labschool.Model.Aluno;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Repository.AlunoRepository;
import techdevinhouse.labschool.Repository.PedagogoRepository;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;

import java.util.Optional;
@AllArgsConstructor
@Service
public class AtendimentoService {

    private AlunoRepository alunoRepo;
    private PedagogoRepository pedagogoRepo;

    public void atendimentos(Integer codigoAluno, Integer codigoPedagogo ){
        Optional<Aluno> alunoOpt =alunoRepo.findById(codigoAluno);
        Optional<Pedagogo> pedagogoOpt = pedagogoRepo.findById(codigoPedagogo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigoAluno);
        if (pedagogoOpt.isEmpty())
            throw  new RegistroNaoEncontradoException("Pedagogo", codigoPedagogo);
        Aluno alunosBD = alunoOpt.get();
        Pedagogo pedagogosBD = pedagogoOpt.get();
        alunosBD.setSituacaoAluno(SituacaoAluno.ATENDIMENTO_PEDAGOGICO);
        alunosBD.setTotalDeAtendimentosPedagogicos(alunosBD.getTotalDeAtendimentosPedagogicos()+1);
        pedagogosBD.setTotalDeAtendimentosPedagogicos(pedagogosBD.getTotalDeAtendimentosPedagogicos()+1);
        Aluno atualizarAtendimentosAluno = alunoRepo.save(alunosBD);
        Pedagogo atualizarAtendimentosPedagogo = pedagogoRepo.save(pedagogosBD);
    }

}
