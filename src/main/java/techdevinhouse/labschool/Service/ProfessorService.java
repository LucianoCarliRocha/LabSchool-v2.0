package techdevinhouse.labschool.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techdevinhouse.labschool.Exception.RegistroExistenteException;
import techdevinhouse.labschool.Exception.RegistroNaoEncontradoException;
import techdevinhouse.labschool.Model.Professor;
import techdevinhouse.labschool.Repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProfessorService {

    private ProfessorRepository repoProfessor;

    public Professor salvarProfessor(Professor professor) {
        Optional<Professor> professorOpt = repoProfessor.findByCpf(professor.getCpf());
        if (professorOpt.isPresent())
            throw new RegistroExistenteException("Professor", professor.getCodigo());
        professor = repoProfessor.save(professor);
        return professor;
    }

    public List<Professor> consultarProfessor() {
        return repoProfessor.findAll();
    }

    public Professor consultarProfessor(Integer codigo) {
        Optional<Professor> professorOpt = repoProfessor.findById(codigo);
        if (professorOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Professor",codigo);
        Professor professor = professorOpt.get();
        return professor;
    }

}
