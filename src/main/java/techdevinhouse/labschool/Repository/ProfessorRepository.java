package techdevinhouse.labschool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techdevinhouse.labschool.Model.Professor;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {


        Optional<Professor> findByCpf(long cpf);
        boolean existsProfessorByCpf (long cpf);

    }
