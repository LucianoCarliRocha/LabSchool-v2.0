package techdevinhouse.labschool.Service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import techdevinhouse.labschool.Exception.RegistroExistenteException;
import techdevinhouse.labschool.Exception.RegistroNaoEncontradoException;
import techdevinhouse.labschool.Model.Aluno;
import techdevinhouse.labschool.Repository.AlunoRepository;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repoAluno;
    private ModelMapper mapper;

    public Aluno salvar(Aluno aluno) {
        Optional<Aluno> alunoOpt = repoAluno.findByCpf(aluno.getCpf());
        if (alunoOpt.isPresent())
           throw new RegistroExistenteException("Aluno", aluno.getCpf());
        aluno = repoAluno.save(aluno);
        return aluno;
    }

   public List<Aluno> consultarAluno() {
        return repoAluno.findAll();
    }
    public List<Aluno> consultarAluno(String situacaoAluno) {
        List<Aluno> lista = repoAluno.findAll();
        List<Aluno> filtrados = new ArrayList<>();
        for (Aluno aluno : lista){
            if (aluno.getSituacaoAluno().toString().equals(situacaoAluno))
                filtrados.add(aluno);
        }
        return filtrados;
    }

    public Aluno consultarAluno(Integer codigo) {
        Optional<Aluno> alunoOpt = repoAluno.findById(codigo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno",codigo);
        Aluno aluno = alunoOpt.get();
        return aluno;
    }

    public Aluno atualizarSituacaoAluno(Integer codigo, SituacaoAluno situacaoAluno) {
        Optional<Aluno> alunoOpt = repoAluno.findById(codigo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigo);
        Aluno alunoBD = alunoOpt.get();
        alunoBD.setSituacaoAluno( situacaoAluno);
        repoAluno.save(alunoBD);
        return alunoBD;
    }

    public void excluirAluno (Integer codigo) {
        boolean existe = repoAluno.existsById(codigo);
        if (!existe)
            throw new RegistroNaoEncontradoException("Aluno", codigo);
        repoAluno.deleteById(codigo);
    }


}
