package techdevinhouse.labschool.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AtendimentosResponse {

    private AlunoResponse aluno;

    private PedagogoResponse pedagogo;
}
