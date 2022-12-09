package techdevinhouse.labschool.Dto;

import lombok.Data;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;
import techdevinhouse.labschool.ValidadorDeEnun.ValorEnum;
import javax.validation.constraints.NotEmpty;

@Data
public class SituacaoRequestAluno {

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorEnum(enumClass = SituacaoAluno.class, message = "{campo.invalido}")
    private String situacaoAluno;
}
