package techdevinhouse.labschool.Dto;

import lombok.Data;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.EstadoProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.ExperienciaProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.FormacaoAcademica;

import java.time.LocalDate;

@Data

public class ProfessorResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate datadeNascimento;

    private long cpf;

    private FormacaoAcademica formacao;

    private ExperienciaProfessor experiencia;

    private EstadoProfessor estado;
}
