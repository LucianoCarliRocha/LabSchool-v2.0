package techdevinhouse.labschool.Dto;

import lombok.Data;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;
import techdevinhouse.labschool.ValidadorDeEnun.ValorEnum;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class AlunoRequest {


        @NotEmpty(message = "{campo.obrigatorio}")
        @Size(min=10, max=50, message = "{campo.invalido}")
        private String nome;

        @NotEmpty(message = "{campo.obrigatorio}")
        private String telefone;

        @NotNull(message = "{campo.obrigatorio}")
        private long cpf;

        @NotNull(message = "{campo.obrigatorio}")
        private LocalDate datadeNascimento;

        @NotEmpty(message = "{campo.obrigatorio}")
        @ValorEnum(enumClass = SituacaoAluno.class, message = "{campo.invalido}")
        private String situacao;

        @NotNull(message = "{campo.obrigatorio}")
        @DecimalMin("0")@DecimalMax("10")
        private float nota ;

}


