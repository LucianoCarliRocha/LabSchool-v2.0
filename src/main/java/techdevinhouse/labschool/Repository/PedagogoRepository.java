package techdevinhouse.labschool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techdevinhouse.labschool.Model.Pedagogo;
import techdevinhouse.labschool.Model.Professor;

import java.util.Optional;

public interface PedagogoRepository extends JpaRepository<Pedagogo, Integer> {

    Optional<Pedagogo> findByCpf(long cpf);
    boolean existsPedagogoByCpf (long cpf);

}
