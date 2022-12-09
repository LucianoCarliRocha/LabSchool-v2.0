package techdevinhouse.labschool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techdevinhouse.labschool.Model.Aluno;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByCpf(long cpf);
    boolean existsAlunoByCpf (long cpf);

}
