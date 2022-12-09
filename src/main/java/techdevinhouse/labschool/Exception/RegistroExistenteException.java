package techdevinhouse.labschool.Exception;

public class RegistroExistenteException extends RuntimeException {

   public RegistroExistenteException(String nomeRecurso, String codigo) {
        super(nomeRecurso + " com identificador " + codigo + " já existente!");
    }

    public RegistroExistenteException(String nomeRecurso, Integer codigo) {
        this(nomeRecurso, String.valueOf(codigo));
    }
    public RegistroExistenteException(String nomeRecurso, long codigo) {
        this(nomeRecurso, String.valueOf(codigo));
    }
}
