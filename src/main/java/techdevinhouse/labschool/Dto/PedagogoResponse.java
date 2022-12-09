package techdevinhouse.labschool.Dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class PedagogoResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate datadeNascimento;

    private long cpf;

    private Integer atendimentos;


}
