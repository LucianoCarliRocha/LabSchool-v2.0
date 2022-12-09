package techdevinhouse.labschool.Exception;

public class RegistroNaoEncontradoException extends  RuntimeException{

    public RegistroNaoEncontradoException( String nomeRecurso, String id) {
        super( "Identificador " + id + " não encontrado!");
    }

    public RegistroNaoEncontradoException(String nomeRecurso, Integer codigo) {
        this(nomeRecurso, String.valueOf(codigo));
    }
}
