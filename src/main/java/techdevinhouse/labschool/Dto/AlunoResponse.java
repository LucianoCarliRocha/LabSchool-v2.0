package techdevinhouse.labschool.Dto;

import lombok.Data;
import techdevinhouse.labschool.SituacaoAtendimentosExperiencia.SituacaoAluno;

import java.time.LocalDate;

@Data

public class AlunoResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate datadeNascimento;

    private long cpf;

    private SituacaoAluno situacao;

    private float nota;

    private Integer atendimentos;

}