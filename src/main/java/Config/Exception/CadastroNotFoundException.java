package Config.Exception;

public class CadastroNotFoundException extends Exception {

	  private static final long serialVersionUID = -7630009569979446777L;

	  public CadastroNotFoundException() {
	    super();
	  }

	  public CadastroNotFoundException(String message, Throwable cause, boolean enableSuppression,
	      boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }

	  public CadastroNotFoundException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public CadastroNotFoundException(String message) {
	    super(message);
	  }

	  public CadastroNotFoundException(Throwable cause) {
	    super(cause);
	  }

	}
