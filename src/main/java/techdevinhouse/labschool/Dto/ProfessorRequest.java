package techdevinhouse.labschool.Dto;

import lombok.Data;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.EstadoProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.ExperienciaProfessor;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.FormacaoAcademica;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;
import techdevinhouse.labschool.ValidadorDeEnun.ValorEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data

public class ProfessorRequest {
    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=10, max=50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    private long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    private LocalDate datadeNascimento;

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorEnum(enumClass = FormacaoAcademica.class, message = "{campo.invalido}")
    private String formacao;

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorEnum(enumClass = ExperienciaProfessor.class, message = "{campo.invalido}")
    private String  experiencia;

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorEnum(enumClass = EstadoProfessor.class, message = "{campo.invalido}")
    private String estado;

}
