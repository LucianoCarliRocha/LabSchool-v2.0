package techdevinhouse.labschool.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AtendimentosRequest {

    @NotNull(message = "{campo.obrigatorio}")
    private Integer codigoAluno;

    @NotNull(message = "{campo.obrigatorio}")
    private Integer codigoPedagogo;

}
