package techdevinhouse.labschool.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
@NoArgsConstructor
@Data
@Entity
@Table(name = "Alunos")
public class Aluno extends Pessoa{

    @Enumerated(value = EnumType.STRING)
    private SituacaoAluno situacaoAluno;

    private float nota;

    private int totalDeAtendimentosPedagogicos = 0;

    public Aluno (Integer codigo, String nome, String telefone, LocalDate DatadeNascimento, long cpf,SituacaoAluno situacaodaMatricula,float nota){
        super ( codigo, nome, telefone, DatadeNascimento, cpf);
        this.situacaoAluno = situacaodaMatricula;
        this.nota = nota;
    }
}
