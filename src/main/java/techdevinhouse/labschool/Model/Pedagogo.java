package techdevinhouse.labschool.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Pedagogos")

public class Pedagogo extends Pessoa{

    private int totalDeAtendimentosPedagogicos = 0;

    public Pedagogo (Integer codigo, String nome, String telefone, LocalDate DatadeNascimento, long cpf) {
        super(codigo, nome, telefone, DatadeNascimento, cpf);
    }
}
