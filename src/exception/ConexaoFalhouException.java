package exception;

import java.sql.SQLException;

public class ConexaoFalhouException extends Exception {

    public ConexaoFalhouException(Throwable cause) {
        super(cause);
    }

    public ConexaoFalhouException(String s, SQLException e) {
        super(s, e);
    }
}
