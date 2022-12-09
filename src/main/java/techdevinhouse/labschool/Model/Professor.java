package techdevinhouse.labschool.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.EstadoProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.ExperienciaProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.FormacaoAcademica;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Professores")

public class Professor extends Pessoa {

    @Enumerated(value = EnumType.STRING)
    private FormacaoAcademica formacaoAcademica;

    @Enumerated(value = EnumType.STRING)
    private ExperienciaProfessor experienciaProfessor;

    @Enumerated(value = EnumType.STRING)
    private EstadoProfessor estadoProfessor;

    public Professor(Integer codigo, String nome, String telefone, LocalDate DatadeNascimento, long cpf,
            FormacaoAcademica formacaoAcademica,ExperienciaProfessor experienciaProfessor, EstadoProfessor estadoProfessor){
        super(codigo, nome, telefone, DatadeNascimento, cpf);
        this.estadoProfessor = estadoProfessor;
        this.experienciaProfessor = experienciaProfessor;
        this.formacaoAcademica = formacaoAcademica;
    }
}